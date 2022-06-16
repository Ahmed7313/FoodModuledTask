package com.example.data.netowrk.servieces

import com.example.data.netowrk.model.CategoryResponseDTO
import retrofit2.http.GET

interface ICategoryService {
    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponseDTO
}