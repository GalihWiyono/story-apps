package com.example.storyapp.view.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J-\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0&2\u0006\u0010\'\u001a\u00020(H\u0016\u00a2\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\u00a8\u00060"}, d2 = {"Lcom/example/storyapp/view/ui/AddStoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/storyapp/databinding/ActivityAddStoryBinding;", "imgFile", "Ljava/io/File;", "launchCamera", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "launchGallery", "photoPath", "", "storyViewModel", "Lcom/example/storyapp/viewmodel/StoryViewModel;", "getStoryViewModel", "()Lcom/example/storyapp/viewmodel/StoryViewModel;", "storyViewModel$delegate", "Lkotlin/Lazy;", "userViewModel", "Lcom/example/storyapp/viewmodel/UserViewModel;", "getUserViewModel", "()Lcom/example/storyapp/viewmodel/UserViewModel;", "userViewModel$delegate", "accessCamera", "", "accessGallery", "allPermissionsGrant", "", "getToken", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setupAction", "setupPermission", "showLoading", "isLoading", "uploadStory", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class AddStoryActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.storyapp.databinding.ActivityAddStoryBinding binding;
    private final kotlin.Lazy userViewModel$delegate = null;
    private final kotlin.Lazy storyViewModel$delegate = null;
    private java.lang.String photoPath;
    private java.io.File imgFile;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> launchCamera = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> launchGallery = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.storyapp.view.ui.AddStoryActivity.Companion Companion = null;
    private static java.lang.String EXTRA_TOKEN = "token";
    private static final java.lang.String[] PERMISSION_REQUIRED = {"android.permission.CAMERA"};
    private static final int REQUEST_CODE = 10;
    
    public AddStoryActivity() {
        super();
    }
    
    private final com.example.storyapp.viewmodel.UserViewModel getUserViewModel() {
        return null;
    }
    
    private final com.example.storyapp.viewmodel.StoryViewModel getStoryViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupPermission() {
    }
    
    private final void getToken() {
    }
    
    private final void setupAction() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final boolean allPermissionsGrant() {
        return false;
    }
    
    private final void accessCamera() {
    }
    
    private final void accessGallery() {
    }
    
    private final void uploadStory() {
    }
    
    private final void showLoading(boolean isLoading) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/storyapp/view/ui/AddStoryActivity$Companion;", "", "()V", "EXTRA_TOKEN", "", "PERMISSION_REQUIRED", "", "[Ljava/lang/String;", "REQUEST_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}