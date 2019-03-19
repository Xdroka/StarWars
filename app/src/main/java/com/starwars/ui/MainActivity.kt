package com.starwars.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.starwars.R
import com.starwars.ui.extensions.toast
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    private val navController by lazy { findNavController(R.id.navHostFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupLinks()
    }

    private fun setupLinks(){
        filmsHomeImageView?.setOnClickListener { navController.navigate(R.id.action_homeFragment_to_filmsFragment) }
        filmsHomeImageView?.setOnLongClickListener { toast("teste") }
        speciesHomeImageView?.setOnClickListener { navController.navigate(R.id.action_homeFragment_to_especiesFragment) }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}
