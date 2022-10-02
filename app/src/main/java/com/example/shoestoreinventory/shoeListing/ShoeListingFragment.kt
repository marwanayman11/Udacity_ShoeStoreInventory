package com.example.shoestoreinventory.shoeListing

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestoreinventory.R
import com.example.shoestoreinventory.ShoeViewModel
import com.example.shoestoreinventory.databinding.FragmentShoeListingBinding


class ShoeListingFragment : Fragment() {
    private lateinit var binding: FragmentShoeListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        val viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        viewModel.list.observe(viewLifecycleOwner) { l ->
            l.forEach {
                if (it != null) {
                    viewModel.addShoe(it, binding)
                }
            }
        }

        binding.add.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeListingFragment_to_shoeDetailFragment)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.menu, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    findNavController().navigate(R.id.action_shoeListingFragment_to_loginFragment2)
                    return NavigationUI.onNavDestinationSelected(
                        menuItem,
                        requireView().findNavController()
                    )
                }
            }, viewLifecycleOwner, Lifecycle.State.RESUMED
        )


        return binding.root
    }
}