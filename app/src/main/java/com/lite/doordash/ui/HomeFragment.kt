package com.lite.doordash.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lite.doordash.databinding.FragmentHomeBinding
import com.lite.doordash.model.common.NetworkObserver
import com.lite.doordash.model.common.NetworkState
import com.lite.doordash.model.homescreen.HomeFragmentViewModelFactory
import com.lite.doordash.model.homescreen.RestaurantModel
import com.lite.doordash.model.homescreen.RestaurantsViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var homeFragmentViewModelFactory: HomeFragmentViewModelFactory
    private lateinit var binding : FragmentHomeBinding

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchRestaurantList()
    }

    private fun fetchRestaurantList() {
        val viewModel = ViewModelProviders.of(this, homeFragmentViewModelFactory).get(RestaurantsViewModel::class.java)
        viewModel.getRestaurantList().observe(this, object : NetworkObserver() {
            override fun onSuccess(result: NetworkState.Success) {
                binding.loading = false
                binding.list.layoutManager = LinearLayoutManager(context)
                binding.list.setHasFixedSize(true)
                binding.adapter = RestaurantListAdapter(result.data as List<RestaurantModel>)
            }

            override fun onError(result: NetworkState.Error) {
                binding.loading = false
            }

            override fun onLoading() {
                binding.loading = true
            }
        })
    }
}