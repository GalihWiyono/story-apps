package com.example.storyapp.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/storyapp/viewmodel/StoryViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/example/storyapp/model/repo/StoryRepository;", "(Lcom/example/storyapp/model/repo/StoryRepository;)V", "allStory", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Lcom/example/storyapp/model/ListStoryItem;", "getAllStory", "()Landroidx/lifecycle/LiveData;", "dataStoryWithLocation", "", "Lcom/example/storyapp/model/ListStoryWithLoc;", "getDataStoryWithLocation", "isLoading", "", "responseUpload", "Lcom/example/storyapp/model/StoryResponse;", "getResponseUpload", "getStoryWithLocation", "", "token", "", "uploadStory", "description", "imgFile", "Ljava/io/File;", "app_debug"})
public final class StoryViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.storyapp.model.repo.StoryRepository storyRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.example.storyapp.model.ListStoryItem>> allStory = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.storyapp.model.ListStoryWithLoc>> dataStoryWithLocation = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.storyapp.model.StoryResponse> responseUpload = null;
    
    @javax.inject.Inject()
    public StoryViewModel(@org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.repo.StoryRepository storyRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.example.storyapp.model.ListStoryItem>> getAllStory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.storyapp.model.ListStoryWithLoc>> getDataStoryWithLocation() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.storyapp.model.StoryResponse> getResponseUpload() {
        return null;
    }
    
    public final void getStoryWithLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void uploadStory(@org.jetbrains.annotations.NotNull()
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.io.File imgFile) {
    }
}