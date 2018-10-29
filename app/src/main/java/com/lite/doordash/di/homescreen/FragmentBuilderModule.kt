package com.lite.doordash.di

import android.support.v4.app.Fragment
import com.lite.doordash.di.homescreen.HomeFragmentComponent
import com.lite.doordash.ui.HomeFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey

import dagger.multibindings.IntoMap

@Module
abstract class FragmentBuilderModule {

    @Binds
    @IntoMap
    @FragmentKey(HomeFragment::class)
    internal abstract fun bindHomeFragment(builder: HomeFragmentComponent.Builder): AndroidInjector.Factory<out Fragment>

}