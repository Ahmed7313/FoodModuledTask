package com.example.extendtaskfoodapp.serviece

import com.example.extendtaskfoodapp.model.CategoryResponse
import com.example.extendtaskfoodapp.model.DishResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ICategoryService {
    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse
}