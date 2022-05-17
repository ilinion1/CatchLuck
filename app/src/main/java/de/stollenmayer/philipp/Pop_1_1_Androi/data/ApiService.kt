package de.stollenmayer.philipp.Pop_1_1_Androi.data

import de.stollenmayer.philipp.Pop_1_1_Androi.data.dto.AllData
import de.stollenmayer.philipp.Pop_1_1_Androi.data.dto.Container
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("CatchLuck3.php")
    suspend fun setDataServer(@Body user: AllData): Container


}