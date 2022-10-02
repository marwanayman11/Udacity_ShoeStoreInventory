package com.example.shoestoreinventory

import android.annotation.SuppressLint
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.shoestoreinventory.databinding.FragmentShoeDetailBinding
import com.example.shoestoreinventory.databinding.FragmentShoeListingBinding

class ShoeViewModel : ViewModel() {

    private var _detail = MutableLiveData<ShoeDetail?>()
    val detail: LiveData<ShoeDetail?>
        get() = _detail
    private var _list = MutableLiveData<List<ShoeDetail?>>()
    val list: LiveData<List<ShoeDetail?>>
        get() = _list

    init {
        _detail.value = ShoeDetail("", "", "", "")
    }

    fun setShoe(binding: FragmentShoeDetailBinding) {
        val model = _detail.value?.let { ShoeDetail(it.name, it.company, it.size, it.description) }
        if (model != null) {
            if (model.name.isNotEmpty() && model.company.isNotEmpty() && model.size.isNotEmpty() && model.description.isNotEmpty()) {
                _list.value = _list.value?.plus(model) ?: listOf(model)
                binding.root.findNavController()
                    .navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
            } else {
                Toast.makeText(binding.root.context, "Please fill all fields", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun addShoe(shoeDetail: ShoeDetail, binding: FragmentShoeListingBinding) {
        val view = TextView(binding.root.context)
        view.text = "------------------------------------------------------------"
        val view1 = TextView(binding.root.context)
        view1.text = "Shoe Name"
        view1.textSize = 25f
        val view2 = TextView(binding.root.context)
        view2.text = shoeDetail.name
        view2.textSize = 15F
        val view3 = TextView(binding.root.context)
        view3.text = "Company"
        view3.textSize = 25f
        val view4 = TextView(binding.root.context)
        view4.text = shoeDetail.company
        view4.textSize = 15F
        val view5 = TextView(binding.root.context)
        view5.text = "Size"
        view5.textSize = 25f
        val view6 = TextView(binding.root.context)
        view6.text = shoeDetail.size
        view6.textSize = 15F
        val view7 = TextView(binding.root.context)
        view7.text = "Description"
        view7.textSize = 25f
        val view8 = TextView(binding.root.context)
        view8.text = shoeDetail.description
        view8.textSize = 15F
        binding.container.addView(view1)
        binding.container.addView(view2)
        binding.container.addView(view3)
        binding.container.addView(view4)
        binding.container.addView(view5)
        binding.container.addView(view6)
        binding.container.addView(view7)
        binding.container.addView(view8)
        binding.container.addView(view)

    }
}