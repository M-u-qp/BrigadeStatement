package com.example.brigadestatement.data.remote

import com.example.brigadestatement.data.remote.dto.BrigadeResponse

interface BrigadeApi {

    suspend fun getListBrigade(): BrigadeResponse
}