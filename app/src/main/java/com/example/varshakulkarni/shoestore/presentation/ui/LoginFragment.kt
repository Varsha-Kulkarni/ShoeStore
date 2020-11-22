package com.example.varshakulkarni.shoestore.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.varshakulkarni.shoestore.R
import com.example.varshakulkarni.shoestore.databinding.FragmentLoginBinding
import com.example.varshakulkarni.shoestore.extensions.validateString

/**
 * Created By Varsha Kulkarni on 18/11/20
 */
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var fragmentViewBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentViewBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        setupUI()

        return fragmentViewBinding.root
    }

    private fun setupUI() {

        //Reset error when text entered
        fragmentViewBinding.etEmail.doAfterTextChanged {
            fragmentViewBinding.tlEmail.error = null
        }
        fragmentViewBinding.etPassword.doAfterTextChanged {
            fragmentViewBinding.tlPassword.error = null
        }

        fragmentViewBinding.btLogin.setOnClickListener {
            //check for text fields empty error
            if (validateInputs()) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }

        fragmentViewBinding.btRegister.setOnClickListener {
            //check for text fields empty error
            if (validateInputs()) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
    }

    private fun validateInputs() =
        fragmentViewBinding.tlEmail.validateString() && fragmentViewBinding.tlPassword.validateString()
}


