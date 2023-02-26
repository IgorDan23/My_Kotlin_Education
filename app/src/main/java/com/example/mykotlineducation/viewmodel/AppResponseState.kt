package com.example.mykotlineducation.viewmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


sealed class AppResponseState  {
    data class OnError(val message: String) :AppResponseState()
    data class OnOk(val message:String):AppResponseState()
}