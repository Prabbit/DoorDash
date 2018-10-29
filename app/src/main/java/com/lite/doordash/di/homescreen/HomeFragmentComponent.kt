package com.lite.doordash.di.homescreen

import com.lite.doordash.ui.HomeFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [HomeFragmentModule::class])
interface HomeFragmentComponent : AndroidInjector<HomeFragment>{
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<HomeFragment>()
}