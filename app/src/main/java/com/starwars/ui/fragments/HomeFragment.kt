package com.starwars.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.starwars.R
import com.starwars.base.BaseFragment
import com.starwars.ui.extensions.toast
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {
    private val navController by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun addListeners() {
        filmsHomeImageView.setOnClickListener { navController.navigate(R.id.action_homeFragment_to_filmsFragment) }
        filmsHomeImageView.setOnLongClickListener { activity?.toast("teste") }
        speciesHomeImageView.setOnClickListener { navController.navigate(R.id.action_homeFragment_to_especiesFragment) }
    }
}
