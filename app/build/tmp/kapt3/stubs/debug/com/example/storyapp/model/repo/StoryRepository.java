package com.example.storyapp.model.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0010J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/example/storyapp/model/repo/StoryRepository;", "", "apiService", "Lcom/example/storyapp/model/service/ApiService;", "storyPagingSource", "Lcom/example/storyapp/model/data/StoryPagingSource;", "(Lcom/example/storyapp/model/service/ApiService;Lcom/example/storyapp/model/data/StoryPagingSource;)V", "_loading", "Landroidx/lifecycle/MutableLiveData;", "", "_responseUpload", "Lcom/example/storyapp/model/StoryResponse;", "_storyWithLocation", "", "Lcom/example/storyapp/model/ListStoryWithLoc;", "loading", "Landroidx/lifecycle/LiveData;", "getLoading", "()Landroidx/lifecycle/LiveData;", "responseUpload", "getResponseUpload", "storyWithLocation", "getStoryWithLocation", "getStoriesPaging", "Landroidx/paging/PagingData;", "Lcom/example/storyapp/model/ListStoryItem;", "getStoriesWithLocation", "", "token", "", "uploadStory", "description", "imgFile", "Ljava/io/File;", "app_debug"})
public final class StoryRepository {
    private final com.example.storyapp.model.service.ApiService apiService = null;
    private final com.example.storyapp.model.data.StoryPagingSource storyPagingSource = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.storyapp.model.ListStoryWithLoc>> _storyWithLocation = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.storyapp.model.ListStoryWithLoc>> storyWithLocation = null;
    private final androidx.lifecycle.MutableLiveData<com.example.storyapp.model.StoryResponse> _responseUpload = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.storyapp.model.StoryResponse> responseUpload = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> loading = null;
    
    @javax.inject.Inject()
    public StoryRepository(@org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.service.ApiService apiService, @org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.data.StoryPagingSource storyPagingSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.storyapp.model.ListStoryWithLoc>> getStoryWithLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.storyapp.model.StoryResponse> getResponseUpload() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.example.storyapp.model.ListStoryItem>> getStoriesPaging() {
        return null;
    }
    
    public final void getStoriesWithLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void uploadStory(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.io.File imgFile) {
    }
}