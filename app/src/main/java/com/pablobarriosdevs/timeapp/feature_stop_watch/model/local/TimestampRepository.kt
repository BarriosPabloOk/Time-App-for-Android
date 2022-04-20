package com.pablobarriosdevs.timeapp.feature_stop_watch.model.local

import com.pablobarriosdevs.timeapp.feature_stop_watch.model.TimestampModel
import kotlinx.coroutines.flow.Flow

interface TimestampRepository {
    suspend fun insertTimestamp(timestamp : TimestampModel)
    fun getAllTimestamps():Flow<List<TimestampModel>>
    suspend fun deleteAllTimestamps()
}