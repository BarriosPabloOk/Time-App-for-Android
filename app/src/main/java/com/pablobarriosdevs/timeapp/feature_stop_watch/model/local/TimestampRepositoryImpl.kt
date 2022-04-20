package com.pablobarriosdevs.timeapp.feature_stop_watch.model.local

import com.pablobarriosdevs.timeapp.feature_stop_watch.model.TimestampModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TimestampRepositoryImpl @Inject constructor(
    private val dao: TimestampDao
) : TimestampRepository {

    override suspend fun insertTimestamp(timestamp: TimestampModel) {
        return dao.insertTimestamp(timestamp)
    }

    override fun getAllTimestamps(): Flow<List<TimestampModel>> {
        return dao.getAllTimestamps()
    }

    override suspend fun deleteAllTimestamps() {
        dao.deleteAllTimestamps()
    }
}