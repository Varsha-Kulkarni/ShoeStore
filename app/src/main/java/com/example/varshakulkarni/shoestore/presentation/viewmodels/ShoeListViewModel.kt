package com.example.varshakulkarni.shoestore.presentation.viewmodels

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.varshakulkarni.shoestore.BR
import com.example.varshakulkarni.shoestore.models.Shoe

/**
 * Created By Varsha Kulkarni on 19/11/20
 */
class ShoeListViewModel : ViewModel() {

    var shoe: Shoe? = null
    private var shoes = mutableListOf<Shoe>()

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    private val _shoeInsertionDone = MutableLiveData<Boolean>()
    val shoeInsertionDone: LiveData<Boolean>
        get() = _shoeInsertionDone

    fun initShoe() {
        shoe = Shoe("",0.0, "", "")
        shoeSizeObservable.shoeSize = ""
    }

    fun addShoe() {
        shoe?.size = shoeSizeObservable.shoeSize.ifBlank { "0.0" }.toDouble()
        shoe?.let { shoe ->
            shoes.add(shoe)
            insertionDone()
            _shoeList.value = shoes
        }
    }

    fun insertionDone() {
        _shoeInsertionDone.value = true
    }

    fun reset() {
        _shoeInsertionDone.value = false
    }

    fun clearShoes() {
        shoes.clear()
    }

    val shoeSizeObservable = ShoeSizeObservable()

    inner class ShoeSizeObservable : BaseObservable() {
        var shoeSize: String = ""

        @Bindable
        fun getNewSize(): String {
            return shoeSize
        }

        fun setNewSize(size: String) {
            if (shoeSize != size) {
                shoeSize = size

                notifyPropertyChanged(BR.newSize)
            }
        }
    }
}