package com.starwars.base

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.starwars.R
import com.starwars.ui.MainActivity
import com.starwars.ui.extensions.showMessageDialog
import retrofit2.HttpException

open class BaseFragment : Fragment(), ViewActions {
    open var lifecycleObserver: LifecycleObserver? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addListeners()
        addEvents()
    }

    override fun addListeners() {}

    override fun addEvents() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleObserver?.let { lifecycle.addObserver(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        lifecycleObserver?.let { lifecycle.removeObserver(it) }
    }

    fun showMessageDialog(
        @StringRes message: Int,
        @StringRes title: Int? = null,
        @StringRes posiveText: Int = android.R.string.ok
    ) {
        (activity as AppCompatActivity?)?.showMessageDialog(message, title, posiveText)
    }

    override fun handleErrors(throwable: Throwable?) {
        when (throwable) {
            is HttpException -> showMessageDialog(R.string.http_error_message)
            else -> showMessageDialog(R.string.error_generic)
        }
    }

}