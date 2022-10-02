package com.example.shoestoreinventory.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentShoeDetailBinding
import com.example.shoestoreinventory.ShoeViewModel

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.shoeModel = viewModel
        binding.lifecycleOwner = this
        binding.saveButton.setOnClickListener {
                viewModel.setShoe(binding)
        }


        binding.cancelButton.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_shoeDetailFragment_to_shoeListingFragment)
        }
        return binding.root
    }


}