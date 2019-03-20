package com.starwars.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver

open class BaseFragment: Fragment() {
    open var lifecycleObserver: LifecycleObserver? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListeners()
        addEvents()
    }

    open fun addListeners(){}

    open fun addEvents(){}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleObserver?.let { lifecycle.addObserver(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleObserver?.let { lifecycle.removeObserver(it) }
    }

}