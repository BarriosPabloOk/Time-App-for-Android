package com.pablobarriosdevs.timeapp.feature_stop_watch.viewmodel

import android.os.Build
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

class StopWatch {

    //state to be observed in viewmodel
    private val _stateFlow = MutableStateFlow("00:00:00")
    val stateFlow : StateFlow<String> = _stateFlow

    //delay provider
    private var coroutine = CoroutineScope(Dispatchers.Main)

    //stopwatch properties: timeInMills is public because will be updated in service's instance
    private var isRunning = false
    private var lastTimestamp = 0L
    var timeInMillis = 0L

    fun start(){
        if (isRunning) return


        coroutine.launch {
            lastTimestamp = System.currentTimeMillis()
            isRunning = true
            while (isRunning){
                delay(1000)
                timeInMillis += System.currentTimeMillis() - lastTimestamp
                lastTimestamp = System.currentTimeMillis()
                _stateFlow.value= formatTime(timeInMillis)
            }
        }
    }

    fun pause(){
        isRunning = false
    }

    fun reset(){
        coroutine.cancel()
        coroutine = CoroutineScope(Dispatchers.Main)

        isRunning = false
        lastTimestamp = 0L
        timeInMillis = 0L
        _stateFlow.value = "00:00:00"

    }

    private fun formatTime(time:Long):String{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val localDateTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(time),
                ZoneId.systemDefault()
            )
            val formatter = DateTimeFormatter.ofPattern("hh:mm:ss")
            //returning
            localDateTime.format(formatter)

        } else {
            //returning
            SimpleDateFormat("hh:mm:ss", Locale.getDefault())
                .format(time).toString()
        }




    }
}