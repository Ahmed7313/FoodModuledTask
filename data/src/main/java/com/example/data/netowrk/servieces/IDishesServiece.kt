package com.example.data.netowrk.servieces

import com.example.data.netowrk.model.DishResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface IDishService {

    @GET("filter.php")
    suspend fun getAllMeals(@Query("c")  dishCategory: String?): DishResponseDTO
}