package com.example.brigadestatement.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.brigadestatement.data.local.dao.entity.BrigadeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BrigadeDao {

    //BrigadeEntity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertEmployee(employee: BrigadeEntity)

    @Delete
    suspend fun deleteEmployee(employee: BrigadeEntity)

    @Query("UPDATE BrigadeEntity SET status=:status WHERE id=:id")
    suspend fun updateBrigadeEmployee(id: Int, status: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBrigade(employees: List<BrigadeEntity>)

    @Query("SELECT * FROM BrigadeEntity")
    fun getAllBrigadeEmployees(): Flow<List<BrigadeEntity?>>

    @Query("SELECT * FROM BrigadeEntity WHERE date=:date")
    fun getBrigadeEmployees(date: String): Flow<List<BrigadeEntity>>
}