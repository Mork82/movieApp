package com.example.demo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demo.data.model.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieentity")
    suspend fun getAllMovie():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie:MovieEntity)
}