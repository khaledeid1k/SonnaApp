package com.sonna.di

import com.sonna.remote.ContentApiServicesAzkar
import com.sonna.remote.ContentApiServicesQuran
import com.sonna.remote.ContentRemoteDataSource
import com.sonna.remote.ContentRemoteDataSourceImp
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
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://github.com/khaledeid1k/Quran-App-Data/blob/main")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideContentApiServicesQuran(@Quran retrofit: Retrofit): ContentApiServicesQuran {
        return retrofit.create(ContentApiServicesQuran::class.java)
    }

    @Provides
    @Singleton
    fun provideContentApiServicesAzkar(@Azkar retrofit: Retrofit): ContentApiServicesAzkar {
        return retrofit.create(ContentApiServicesAzkar::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(contentApiServicesQuran: ContentApiServicesQuran,contentApiServicesAzkar: ContentApiServicesAzkar): ContentRemoteDataSource {
        return ContentRemoteDataSourceImp(contentApiServicesQuran,contentApiServicesAzkar)
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


