package com.giraffe.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/giraffe/data/repository/ContentRepositoryImp;", "Lcom/giraffe/domain/repository/ContentRepository;", "remoteDataSource", "Lcom/giraffe/data/remote/ContentRemoteDataSource;", "contentLocalDataSource", "Lcom/giraffe/data/local/ContentLocalDataSource;", "(Lcom/giraffe/data/remote/ContentRemoteDataSource;Lcom/giraffe/data/local/ContentLocalDataSource;)V", "getSurahes", "Lcom/giraffe/domain/entity/quran/AllSurahesEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSurah", "", "surahEntity", "Lcom/giraffe/domain/entity/quran/SurahEntity;", "(Lcom/giraffe/domain/entity/quran/SurahEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class ContentRepositoryImp implements com.giraffe.domain.repository.ContentRepository {
    private final com.giraffe.data.remote.ContentRemoteDataSource remoteDataSource = null;
    private final com.giraffe.data.local.ContentLocalDataSource contentLocalDataSource = null;
    
    public ContentRepositoryImp(@org.jetbrains.annotations.NotNull
    com.giraffe.data.remote.ContentRemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull
    com.giraffe.data.local.ContentLocalDataSource contentLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getSurahes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.giraffe.domain.entity.quran.AllSurahesEntity> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object insertSurah(@org.jetbrains.annotations.NotNull
    com.giraffe.domain.entity.quran.SurahEntity surahEntity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
}