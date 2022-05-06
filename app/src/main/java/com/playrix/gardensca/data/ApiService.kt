package com.playrix.gardensca.data

import com.playrix.gardensca.data.dto.AllData
import com.playrix.gardensca.data.dto.Container
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @POST("CatchLuck3.php")
    suspend fun setDataServer(@Body user: AllData): Container


}