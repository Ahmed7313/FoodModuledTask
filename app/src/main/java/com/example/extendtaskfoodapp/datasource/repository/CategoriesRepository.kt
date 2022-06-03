package com.example.extendtaskfoodapp.datasource

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.extendtaskfoodapp.datasource.usecase.IGetCategoriesUseCase
import com.example.extendtaskfoodapp.model.CategoryResponse
import com.example.extendtaskfoodapp.serviece.ICategoryService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoryRepository @Inject constructor(
    val service : ICategoryService
) : ICategoryRepository{
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories()
    }
}