package com.starwars.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver

open class BaseFragment: Fragment() {
    open var lifecycleObserver: LifecycleObserver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleObserver?.let { lifecycle.addObserver(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleObserver?.let { lifecycle.removeObserver(it) }
    }

}