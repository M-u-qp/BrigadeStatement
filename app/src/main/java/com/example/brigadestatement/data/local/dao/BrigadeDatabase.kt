package com.example.brigadestatement.data.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.brigadestatement.data.local.dao.entity.BrigadeEntity

@Database(entities = [BrigadeEntity::class], version = 1)
abstract class BrigadeDatabase: RoomDatabase() {

    abstract val brigadeDao: BrigadeDao
}