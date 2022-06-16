package com.example.data.netowrk.di

import com.example.data.netowrk.servieces.ICategoryService
import com.example.data.netowrk.servieces.IDishService
import com.example.data.repository.CategoryRepository
import com.example.data.repository.DishRepository
import com.example.domain.repository.ICategoryRepository
import com.example.domain.repository.IDishRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit) : ICategoryService {
        return retrofit.create(ICategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideMealService(retrofit: Retrofit): IDishService {
        return retrofit.create(IDishService::class.java)
    }


    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository


        @Binds
        @Singleton
        fun provideMealRepository(repo: DishRepository): IDishRepository

    }

}