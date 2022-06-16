package com.example.domain.repository

import com.example.domain.model.CategoryResponse

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}