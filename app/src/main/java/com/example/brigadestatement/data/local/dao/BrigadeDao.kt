package com.example.brigadestatement.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.brigadestatement.data.local.dao.entity.BrigadeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BrigadeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertEmployee(employee: BrigadeEntity)

    @Delete
    suspend fun deleteEmployee(employee: BrigadeEntity)

    @Update
    suspend fun updateEmployee(employee: BrigadeEntity)

    @Query("SELECT * FROM BrigadeEntity")
fun getAllBrigadeEmployees(): Flow<List<BrigadeEntity?>>
}