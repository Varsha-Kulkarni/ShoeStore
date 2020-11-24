package com.example.varshakulkarni.shoestore.extensions

import com.example.varshakulkarni.shoestore.R
import com.google.android.material.textfield.TextInputLayout
import timber.log.Timber


/**
 * Created By Varsha Kulkarni on 20/11/20
 */
fun TextInputLayout.validateString() : Boolean {
    var noErrors = true
    val textString = this.editText?.text.toString()
    Timber.i(textString)
    if (textString.isEmpty()) {
        this.error = resources.getString(R.string.error_string)
        noErrors = false
    } else {
        this.error = null

    }

    return noErrors
}

fun TextInputLayout.validateDouble() : Boolean {
    var noErrors = true
    if (this.validateString()) {
        if (this.editText?.text.toString().toDouble() == 0.0) {
            this.error = resources.getString(R.string.size_error_string)
            noErrors = false
        } else {
            this.error = null

        }
    }

    return noErrors
}
