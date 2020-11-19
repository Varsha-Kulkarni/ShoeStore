package com.example.varshakulkarni.shoestore.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.varshakulkarni.shoestore.R
import com.example.varshakulkarni.shoestore.databinding.FragmentWelcomeBinding


/**
 * Created By Varsha Kulkarni on 18/11/20
 */

class WelcomeFragment: Fragment(R.layout.fragment_welcome){

    private lateinit var fragmentViewBinding: FragmentWelcomeBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentViewBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false)

        navController = findNavController()

        fragmentViewBinding.btNext.setOnClickListener {
            navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())

        }
        return fragmentViewBinding.root
    }
}