package com.example.shoestoreinventory.instructions
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding : FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_instructions, container, false)
        binding.skipInstructions.setOnClickListener {
            it.findNavController().navigate(R.id.action_instructionsFragment_to_shoeListingFragment)
        }
        return binding.root
    }


}