package com.lite.doordash.di

import android.app.Activity
import com.lite.doordash.di.homescreen.HomeActivityComponent
import com.lite.doordash.ui.HomeActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(HomeActivity::class)
    abstract fun bindHomeActivity(builder: HomeActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}