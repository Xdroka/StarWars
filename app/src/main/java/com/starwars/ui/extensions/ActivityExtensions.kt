package com.starwars.ui.extensions

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.showMessageDialog(message: Int, title: Int? = null, yesButtonText: Int = android.R.string.ok) {
    val alertDialog = AlertDialog.Builder(this, android.R.style.Theme_Dialog)

    with(alertDialog) {
        title?.let { setTitle(it) }
        setMessage(message)
        setPositiveButton(yesButtonText, null)
    }
    alertDialog.show()
}