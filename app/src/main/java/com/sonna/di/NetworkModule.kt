package com.sonna.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient():OkHttpClient{
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()
                //.addHeader(Constants.SHOPIFY_HEADER, Constants.ACCESS_TOKEN)
                .build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

    @Provides
    @Singleton
    @Quran
    fun provideRetrofitQuran(okHttpClient:OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.alquran.cloud/v1/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    @Hadith
    fun provideRetrofitHadith(okHttpClient:OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("hadith.com")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideContentApiServices(@Quran retrofit: Retrofit): com.sonna.data.remote.ContentApiServices {
        return retrofit.create(com.sonna.data.remote.ContentApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(contentApiServices: com.sonna.data.remote.ContentApiServices): com.sonna.data.remote.ContentRemoteDataSource {
        return com.sonna.data.remote.ContentRemoteDataSourceImp(contentApiServices)
    }
}


@Qualifier
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD
)
annotation class Quran

@Qualifier
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD
)
annotation class Hadith


