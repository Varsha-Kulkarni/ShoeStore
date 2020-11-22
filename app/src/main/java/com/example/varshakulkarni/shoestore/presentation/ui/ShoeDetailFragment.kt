package com.example.varshakulkarni.shoestore.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.varshakulkarni.shoestore.R
import com.example.varshakulkarni.shoestore.databinding.FragmentShoedetailBinding
import com.example.varshakulkarni.shoestore.extensions.validateDouble
import com.example.varshakulkarni.shoestore.extensions.validateString
import com.example.varshakulkarni.shoestore.presentation.viewmodels.ShoeListViewModel


/**
 * Created By Varsha Kulkarni on 19/11/20
 */
class ShoeDetailFragment : Fragment(){

    val shoeViewModel: ShoeListViewModel by activityViewModels()

    lateinit var fragmentViewBinding: FragmentShoedetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoedetail, container, false)

        setupUI()

        return fragmentViewBinding.root
    }

    private fun setupUI() {

        fragmentViewBinding.viewModel = shoeViewModel

        fragmentViewBinding.btSave.setOnClickListener {
            if ( validateInputs() )
                shoeViewModel.addShoe()
        }

        shoeViewModel.shoeInsertionDone.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().navigateUp()
            }
        })

        fragmentViewBinding.etName.doAfterTextChanged {
            fragmentViewBinding.tlName.error = null
        }
        fragmentViewBinding.etBrand.doAfterTextChanged {
            fragmentViewBinding.tlBrand.error = null
        }
        fragmentViewBinding.etSize.doAfterTextChanged {
            fragmentViewBinding.tlSize.error = null
        }
    }

    private fun validateInputs() =
        fragmentViewBinding.tlName.validateString() && fragmentViewBinding.tlBrand.validateString() &&
                fragmentViewBinding.tlDescription.validateString() && fragmentViewBinding.tlSize.validateDouble()


    override fun onDestroyView() {
        super.onDestroyView()
        shoeViewModel.reset()
    }
}