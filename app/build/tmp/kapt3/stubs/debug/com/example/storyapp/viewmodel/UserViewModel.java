package com.example.storyapp.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\bJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/example/storyapp/viewmodel/UserViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lcom/example/storyapp/model/repo/UserRepository;", "preference", "Lcom/example/storyapp/model/UserPreference;", "(Lcom/example/storyapp/model/repo/UserRepository;Lcom/example/storyapp/model/UserPreference;)V", "isLoading", "Landroidx/lifecycle/LiveData;", "", "()Landroidx/lifecycle/LiveData;", "loginResult", "Lcom/example/storyapp/model/LoginResult;", "getLoginResult", "userStatus", "getUserStatus", "clearUserPreference", "", "getUserPreferences", "saveUserPreference", "userLogin", "loginUser", "Lcom/example/storyapp/model/LoginUser;", "userRegister", "registerUser", "Lcom/example/storyapp/model/RegisterUser;", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.storyapp.model.repo.UserRepository userRepository = null;
    private final com.example.storyapp.model.UserPreference preference = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> userStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.example.storyapp.model.LoginResult> loginResult = null;
    
    @javax.inject.Inject()
    public UserViewModel(@org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.repo.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.UserPreference preference) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getUserStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.storyapp.model.LoginResult> getLoginResult() {
        return null;
    }
    
    public final void userLogin(@org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.LoginUser loginUser) {
    }
    
    public final void userRegister(@org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.RegisterUser registerUser) {
    }
    
    public final void saveUserPreference(@org.jetbrains.annotations.NotNull()
    com.example.storyapp.model.LoginResult loginResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.storyapp.model.LoginResult> getUserPreferences() {
        return null;
    }
    
    public final void clearUserPreference() {
    }
}