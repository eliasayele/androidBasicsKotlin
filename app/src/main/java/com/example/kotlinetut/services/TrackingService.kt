package com.example.kotlinetut.services

import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.example.kotlinetut.other.Constants.ACTION_START_OR_RESUME_SERVICE

class TrackingService  : LifecycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            intent?.let {
//                when(it.action){
//                    ACTION_START_OR_RESUME_SERVICE ->
//                }
            }
        return super.onStartCommand(intent, flags, startId)
    }
}