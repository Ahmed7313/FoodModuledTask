package com.example.extendtaskfoodapp.serviece

import com.example.extendtaskfoodapp.model.CategoryResponse
import retrofit2.http.GET

interface ICategoryService {
    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse
}