package com.lite.doordash.di.homescreen

import com.lite.doordash.di.FragmentBuilderModule
import com.lite.doordash.ui.HomeActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Subcomponent(modules = [AndroidSupportInjectionModule::class, HomeActivityModule::class, FragmentBuilderModule::class])
interface HomeActivityComponent : AndroidInjector<HomeActivity> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<HomeActivity>()
}