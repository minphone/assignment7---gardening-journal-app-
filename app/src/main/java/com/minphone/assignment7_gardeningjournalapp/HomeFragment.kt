package com.minphone.assignment7_gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

      private var binding: FragmentHomeBinding? = null

      override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {

            binding = FragmentHomeBinding.inflate(layoutInflater)
            return binding!!.root

      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding?.btnGardenLog?.setOnClickListener {
                  findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToGardenLogFragment())
            }
            binding?.btnAddGarden?.setOnClickListener {
                  findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddPlantFragment())
            }
      }

      override fun onDestroyView() {
            super.onDestroyView()
            binding = null
      }
}