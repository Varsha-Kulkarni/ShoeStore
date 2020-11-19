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


/**
 * Created By Varsha Kulkarni on 18/11/20
 */
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var fragmentViewBinding: FragmentLoginBinding
    private lateinit var navController: NavController

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()

        // If the user presses the back button, bring them back to the home screen.
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            navController.popBackStack(R.id.nav_welcome, false)
        }
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
            if (checkErrors()) {
                navController.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
        fragmentViewBinding.btRegister.setOnClickListener {
            //check for text fields empty error
            if (checkErrors()) {
                navController.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }
    }

    private fun checkErrors(): Boolean {
        var noErrors = true
        fragmentViewBinding.tlEmail.apply {
            if (this.editText?.text.toString().isEmpty()) {
                this.error = resources.getString(R.string.email_error_string)
                noErrors = false
            } else {
                this.error = null

            }
        }
        fragmentViewBinding.tlPassword.apply {
            if (this.editText?.text.toString().isEmpty()) {
                this.error = resources.getString(R.string.password_error_string)
                noErrors = false
            } else {
                this.error = null

            }
        }
        return noErrors
    }
}


