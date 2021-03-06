// Generated by Dagger (https://dagger.dev).
package com.example.storyapp.model.data;

import com.example.storyapp.model.UserPreference;
import com.example.storyapp.model.service.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class StoryPagingSource_Factory implements Factory<StoryPagingSource> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<UserPreference> userPreferenceProvider;

  public StoryPagingSource_Factory(Provider<ApiService> apiServiceProvider,
      Provider<UserPreference> userPreferenceProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.userPreferenceProvider = userPreferenceProvider;
  }

  @Override
  public StoryPagingSource get() {
    return newInstance(apiServiceProvider.get(), userPreferenceProvider.get());
  }

  public static StoryPagingSource_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<UserPreference> userPreferenceProvider) {
    return new StoryPagingSource_Factory(apiServiceProvider, userPreferenceProvider);
  }

  public static StoryPagingSource newInstance(ApiService apiService,
      UserPreference userPreference) {
    return new StoryPagingSource(apiService, userPreference);
  }
}
