package com.example.data.repository

import com.example.data.netowrk.mapper.toDomain
import com.example.data.netowrk.servieces.ICategoryService
import com.example.domain.model.CategoryResponse
import com.example.domain.repository.ICategoryRepository
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    val service : ICategoryService
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories().toDomain()
    }
}