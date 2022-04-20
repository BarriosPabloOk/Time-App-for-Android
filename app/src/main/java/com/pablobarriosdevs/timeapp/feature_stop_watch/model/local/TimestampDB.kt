package com.pablobarriosdevs.timeapp.feature_stop_watch.model.local

import androidx.room.Database
import com.pablobarriosdevs.timeapp.feature_stop_watch.model.TimestampModel

@Database(
    entities = [TimestampModel::class],
    version = 1
)
abstract class TimestampDB {

    abstract val dao: TimestampDao

    companion object{
        const val DATABASE_NAME = "timestamp_db"
    }
}