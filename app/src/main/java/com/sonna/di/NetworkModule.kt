package com.sonna.di

import com.google.gson.GsonBuilder
import com.sonna.remote.CoreApiServicesAzkar
import com.sonna.remote.CoreApiServicesQuran
import com.sonna.remote.CoreRemoteDataSource
import com.sonna.remote.CoreRemoteDataSourceImp
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
    @Azkar
    fun provideRetrofitAzkar(okHttpClient:OkHttpClient):Retrofit{
        val gson = GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://raw.githubusercontent.com/khaledeid1k/Quran-App-Data/main/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideContentApiServicesQuran(@Quran retrofit: Retrofit): CoreApiServicesQuran {
        return retrofit.create(CoreApiServicesQuran::class.java)
    }

    @Provides
    @Singleton
    fun provideContentApiServicesAzkar(@Azkar retrofit: Retrofit): CoreApiServicesAzkar {
        return retrofit.create(CoreApiServicesAzkar::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(coreApiServicesQuran: CoreApiServicesQuran, coreApiServicesAzkar: CoreApiServicesAzkar): CoreRemoteDataSource {
        return CoreRemoteDataSourceImp(coreApiServicesQuran,coreApiServicesAzkar)
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

@Qualifier
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.FIELD
)
annotation class Azkar


