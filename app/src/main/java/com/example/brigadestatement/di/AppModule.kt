package com.example.brigadestatement.di

import android.app.Application
import androidx.room.Room
import com.example.brigadestatement.data.local.dao.BrigadeDao
import com.example.brigadestatement.data.local.dao.BrigadeDatabase
import com.example.brigadestatement.data.repository.BrigadeRepositoryImpl
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.usecases.db.BrigadeUseCases
import com.example.brigadestatement.domain.usecases.db.DeleteEmployee
import com.example.brigadestatement.domain.usecases.db.GetAllBrigadeEmployees
import com.example.brigadestatement.domain.usecases.db.UpdateEmployee
import com.example.brigadestatement.domain.usecases.db.UpsertEmployee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBrigadeUseCases(
        brigadeRepository: BrigadeRepository
    ): BrigadeUseCases {
        return BrigadeUseCases(
            upsertEmployee = UpsertEmployee(brigadeRepository),
            updateEmployee = UpdateEmployee(brigadeRepository),
            deleteEmployee = DeleteEmployee(brigadeRepository),
            getAllBrigadeEmployees = GetAllBrigadeEmployees(brigadeRepository)
        )
    }

    @Provides
    @Singleton
    fun provideBrigadeRepository(
        brigadeDao: BrigadeDao
    ): BrigadeRepository = BrigadeRepositoryImpl(
        brigadeDao = brigadeDao
    )

    @Provides
    @Singleton
    fun provideBrigadeDatabase(
        application: Application
    ): BrigadeDatabase {
//        return Room.databaseBuilder(
        return Room.inMemoryDatabaseBuilder(
            context = application,
            klass = BrigadeDatabase::class.java
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideBrigadeDao(
        brigadeDatabase: BrigadeDatabase
    ): BrigadeDao = brigadeDatabase.brigadeDao
}