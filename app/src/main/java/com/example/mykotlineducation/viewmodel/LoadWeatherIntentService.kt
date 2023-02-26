package com.example.mykotlineducation.viewmodel

import android.app.IntentService
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.mykotlineducation.BuildConfig
import com.example.mykotlineducation.repository.OnServerResponse
import com.example.mykotlineducation.repository.weatherDTO.WeatherDTO
import com.example.mykotlineducation.utils.*
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class LoadWeatherIntentService(
    private val name: String = " "
) : IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        intent?.let {
            val lat = it.getDoubleExtra("let", 0.0)
            val lon = it.getDoubleExtra("lon", 0.0)
            val message = Intent(WAVE)
            val url = "${YANDEX_DOMAIN}${YANDEX_ENDPOINT}${CITY_LAT}=${lat}&${CITY_LON}=${lon}"
            val uri = URL(url)
            val urlConnection: HttpsURLConnection =
                (uri.openConnection() as HttpsURLConnection).apply {
                    addRequestProperty(API_KEY, BuildConfig.WEATHER_API_KEY)
                }


            val responseCode = urlConnection.responseCode
            val ok = 200..299
            if (responseCode in ok) {
                message.putExtra(KEY_BUNDLE_STATE_MESS,"Погода загрузилась")
            } else {
                message.putExtra(KEY_BUNDLE_STATE_MESS,"Что то пошло не так")

            }



            try {
                val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)

                message.putExtra(KEY_BUNDLE_WEATHERDTO, weatherDTO)

                //sendBroadcast(message)
            } catch (e: Exception) {
                e.message
            } finally {
                LocalBroadcastManager.getInstance(this).sendBroadcast(message)
                urlConnection.disconnect()
            }
        }
    }
}