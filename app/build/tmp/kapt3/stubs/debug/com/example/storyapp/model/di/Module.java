package com.example.storyapp.model.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/storyapp/model/di/Module;", "", "()V", "BASE_URL_API", "", "getBASE_URL_API", "()Ljava/lang/String;", "setBASE_URL_API", "(Ljava/lang/String;)V", "provideApiService", "Lcom/example/storyapp/model/service/ApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideRetrofit", "app_debug"})
@dagger.Module()
public final class Module {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.storyapp.model.di.Module INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String BASE_URL_API = "https://story-api.dicoding.dev/v1/";
    
    private Module() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBASE_URL_API() {
        return null;
    }
    
    public final void setBASE_URL_API(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final retrofit2.Retrofit provideRetrofit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.example.storyapp.model.service.ApiService provideApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}