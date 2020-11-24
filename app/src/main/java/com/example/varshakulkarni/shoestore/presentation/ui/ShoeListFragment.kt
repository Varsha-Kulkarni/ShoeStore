package com.example.varshakulkarni.shoestore.presentation.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.varshakulkarni.shoestore.R
import com.example.varshakulkarni.shoestore.databinding.FragmentShoelistBinding
import com.example.varshakulkarni.shoestore.databinding.ItemShoelistBinding
import com.example.varshakulkarni.shoestore.presentation.viewmodels.ShoeListViewModel


/**
 * Created By Varsha Kulkarni on 19/11/20
 */

class ShoeListFragment : Fragment() {

    private val shoeViewModel: ShoeListViewModel by activityViewModels()

    lateinit var fragmentViewBinding: FragmentShoelistBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fragmentViewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoelist, container, false)

        setupUI(inflater, container)

        return fragmentViewBinding.root
    }

    private fun setupUI( inflater: LayoutInflater,
                         container: ViewGroup?,){

        //to add new shoe item, enter shoe details
        fragmentViewBinding.fabAddShoe.setOnClickListener {
            shoeViewModel.initShoe()
            findNavController().navigate(ShoeListFragmentDirections.actionShoelistFragmentToShoedetailFragment())
        }

        //Observe for new shoe detail added, update UI by adding new shoe item view
        shoeViewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            if (shoeList.isNotEmpty()) fragmentViewBinding.emptyListText.visibility = View.GONE
            shoeList.forEach { shoe ->
                val itemBinding: ItemShoelistBinding =
                        DataBindingUtil.inflate(inflater, R.layout.item_shoelist, container, false)
                itemBinding.shoe = shoe
                fragmentViewBinding.shoeList.addView(itemBinding.root)
            }
        })

        setHasOptionsMenu(true)

    }

    private fun logout() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoelistFragmentToLoginFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_overflow, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itemLogout -> {
                shoeViewModel.clearShoes()
                logout()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}