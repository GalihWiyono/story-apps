package com.example.storyapp.model.service;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\bH\'J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\r\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0011H\'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0014H\'J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/storyapp/model/service/ApiService;", "", "getAllStoriesLocation", "Lretrofit2/Call;", "Lcom/example/storyapp/model/StoryResponseWithLoc;", "auth", "", "loc", "", "getAllStoriesPaging", "Lretrofit2/Response;", "Lcom/example/storyapp/model/StoriesResponse;", "page", "size", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "Lcom/example/storyapp/model/LoginResponse;", "Lcom/example/storyapp/model/LoginUser;", "registerUser", "Lcom/example/storyapp/model/RegisterResponse;", "Lcom/example/storyapp/model/RegisterUser;", "uploadStory", "Lcom/example/storyapp/model/StoryResponse;", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "login")
    public abstract retrofit2.Call<com.example.storyapp.model.LoginResponse> loginUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.storyapp.model.LoginUser loginUser);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "register")
    public abstract retrofit2.Call<com.example.storyapp.model.RegisterResponse> registerUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.example.storyapp.model.RegisterUser registerUser);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "stories")
    @retrofit2.http.Multipart()
    public abstract retrofit2.Call<com.example.storyapp.model.StoryResponse> uploadStory(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Part(value = "description")
    okhttp3.RequestBody description);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "stories")
    public abstract java.lang.Object getAllStoriesPaging(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.storyapp.model.StoriesResponse>> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "stories")
    public abstract retrofit2.Call<com.example.storyapp.model.StoryResponseWithLoc> getAllStoriesLocation(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String auth, @retrofit2.http.Query(value = "location")
    int loc);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}