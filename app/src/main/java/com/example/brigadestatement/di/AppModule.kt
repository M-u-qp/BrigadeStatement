package com.example.brigadestatement.di

import android.app.Application
import androidx.room.Room
import com.example.brigadestatement.data.local.dao.BrigadeDao
import com.example.brigadestatement.data.local.dao.BrigadeDatabase
import com.example.brigadestatement.data.remote.BrigadeApi
import com.example.brigadestatement.data.remote.BrigadeApiImpl
import com.example.brigadestatement.data.repository.BrigadeRepositoryImpl
import com.example.brigadestatement.domain.repository.BrigadeRepository
import com.example.brigadestatement.domain.usecases.brigade.BrigadeUseCases
import com.example.brigadestatement.domain.usecases.brigade.DeleteEmployee
import com.example.brigadestatement.domain.usecases.brigade.GetAllBrigadeEmployees
import com.example.brigadestatement.domain.usecases.brigade.GetBrigade
import com.example.brigadestatement.domain.usecases.brigade.GetBrigadeEmployees
import com.example.brigadestatement.domain.usecases.employees.GetEmployees
import com.example.brigadestatement.domain.usecases.brigade.InsertBrigade
import com.example.brigadestatement.domain.usecases.brigade.UpdateBrigadeEmployee
import com.example.brigadestatement.domain.usecases.brigade.UpsertEmployee
import com.example.brigadestatement.domain.usecases.employees.EmployeesUseCases
import com.example.brigadestatement.ui.util.Constants.NAME_DATABASE
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
            updateBrigadeEmployee = UpdateBrigadeEmployee(brigadeRepository),
            deleteEmployee = DeleteEmployee(brigadeRepository),
            getAllBrigadeEmployees = GetAllBrigadeEmployees(brigadeRepository),
            getBrigade = GetBrigade(brigadeRepository),
            getBrigadeEmployees = GetBrigadeEmployees(brigadeRepository),
            insertBrigade = InsertBrigade(brigadeRepository)
        )
    }

    @Provides
    @Singleton
    fun provideEmployeesUseCases(
        brigadeRepository: BrigadeRepository
    ): EmployeesUseCases {
        return EmployeesUseCases(
            getEmployees = GetEmployees(brigadeRepository)
        )
    }

    @Provides
    @Singleton
    fun provideBrigadeApi(): BrigadeApi = BrigadeApiImpl()

    @Provides
    @Singleton
    fun provideBrigadeRepository(
        brigadeDao: BrigadeDao,
        brigadeApi: BrigadeApi
    ): BrigadeRepository = BrigadeRepositoryImpl(
        brigadeDao = brigadeDao,
        brigadeApi = brigadeApi
    )

    @Provides
    @Singleton
    fun provideBrigadeDatabase(
        application: Application
    ): BrigadeDatabase {
        return Room.databaseBuilder(
//        return Room.inMemoryDatabaseBuilder(
            context = application,
            klass = BrigadeDatabase::class.java,
            name = NAME_DATABASE
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