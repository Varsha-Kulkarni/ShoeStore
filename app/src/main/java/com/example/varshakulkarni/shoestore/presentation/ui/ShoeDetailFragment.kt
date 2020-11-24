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

        //add shoe detail when all the fields are filled
        fragmentViewBinding.btSave.setOnClickListener {
            if ( validateInputs() )
                shoeViewModel.addShoe()
        }

        //When Save/Cancel clicked, go back to ShoeList screen to view the new shoe detail added
        shoeViewModel.shoeInsertionDone.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().navigateUp()
            }
        })

        //When the user starts entering text into the fields, reset the error to null
        fragmentViewBinding.etName.doAfterTextChanged {
            fragmentViewBinding.tlName.error = null
        }
        fragmentViewBinding.etBrand.doAfterTextChanged {
            fragmentViewBinding.tlBrand.error = null
        }
        fragmentViewBinding.etSize.doAfterTextChanged {
            fragmentViewBinding.tlSize.error = null
        }
        fragmentViewBinding.etBrand.doAfterTextChanged {
            fragmentViewBinding.tlDescription.error = null
        }
    }

    private fun validateInputs() : Boolean {
        var validInputs = true

        if (!(fragmentViewBinding.tlName.validateString())) {
            validInputs = false
        }
        if (!(fragmentViewBinding.tlBrand.validateString())) {
            validInputs = false
        }

        if (!(fragmentViewBinding.tlSize.validateDouble())) {
            validInputs = false
        }

        if (!(fragmentViewBinding.tlDescription.validateString())) {
            validInputs = false
        }

        return validInputs
    }

    override fun onDestroyView() {
        super.onDestroyView()
        shoeViewModel.reset()
    }
}