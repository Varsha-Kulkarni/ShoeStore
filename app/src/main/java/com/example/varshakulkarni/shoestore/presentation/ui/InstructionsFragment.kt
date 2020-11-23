package com.example.varshakulkarni.shoestore.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.varshakulkarni.shoestore.R
import com.example.varshakulkarni.shoestore.databinding.FragmentInstructionsBinding


/**
 * Created By Varsha Kulkarni on 18/11/20
 */
class InstructionsFragment : Fragment(R.layout.fragment_instructions) {

    private lateinit var fragmentViewBinding: FragmentInstructionsBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        fragmentViewBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_instructions, container, false)

        fragmentViewBinding.btNext.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoelistFragment())
        }
        return fragmentViewBinding.root
    }
}