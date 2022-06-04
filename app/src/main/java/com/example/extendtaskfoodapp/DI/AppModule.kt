package com.example.extendtaskfoodapp.DI

import com.example.extendtaskfoodapp.datasource.CategoryRepository
import com.example.extendtaskfoodapp.datasource.ICategoryRepository
import com.example.extendtaskfoodapp.datasource.repository.DishRepository
import com.example.extendtaskfoodapp.datasource.repository.IDishRepository
import com.example.extendtaskfoodapp.datasource.usecase.*
import com.example.extendtaskfoodapp.serviece.ICategoryService
import com.example.extendtaskfoodapp.serviece.IDishService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule{

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
    fun providesCategoryService(retrofit: Retrofit) : ICategoryService{
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
        fun provideGetCategoryUseCase(uc: GetCategoriesUseCase): IGetCategoriesUseCase

        @Binds
        @Singleton
        fun provideMealRepository(repo: DishRepository): IDishRepository

        @Binds
        @Singleton
        fun provideDishUseCase(uc: GetDishUseCase): IDishesUseCase
    }


}