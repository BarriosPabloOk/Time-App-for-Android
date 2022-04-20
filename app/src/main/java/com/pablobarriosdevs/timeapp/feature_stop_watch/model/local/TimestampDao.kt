package com.pablobarriosdevs.timeapp.feature_stop_watch.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pablobarriosdevs.timeapp.feature_stop_watch.model.TimestampModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TimestampDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimestamp(timestamp : TimestampModel)

    @Query("SELECT * FROM timestamps")
    fun getAllTimestamps(): Flow<List<TimestampModel>>

    @Query("DELETE FROM timestamps")
    suspend fun deleteAllTimestamps()
}