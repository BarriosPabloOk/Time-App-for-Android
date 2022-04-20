package com.pablobarriosdevs.timeapp.feature_stop_watch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timestamps")
data class TimestampModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val partTimestamp: Long,
    val totalTime: Long,
)
