package com.minphone.assignment7_gardeningjournalapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.minphone.assignment7_gardeningjournalapp.adapter.AdapterClickListener
import com.minphone.assignment7_gardeningjournalapp.adapter.PlantRecyclerAdapter
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.minphone.assignment7_gardeningjournalapp.model.Plant
import com.minphone.assignment7_gardeningjournalapp.viewModel.GardenLogViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GardenLogFragment : Fragment() {

      private var _binding: FragmentGardenLogBinding? = null
      private val binding get() = _binding!!

      private lateinit var viewModel: GardenLogViewModel

      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {
            _binding = FragmentGardenLogBinding.inflate(inflater, container, false)
            return binding.root

      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this)[GardenLogViewModel::class.java]

            viewModel.plants.observe(viewLifecycleOwner) { plants ->
                  val adapter = PlantRecyclerAdapter(plants, object : AdapterClickListener {
                        override fun onItemClicked(plantId: Int) {
                              findNavController().navigate(
                                    GardenLogFragmentDirections.actionGardenLogFragmentToPlantDetailFragment(
                                          plantId = plantId
                                    )
                              )
                        }
                  })
                  binding.rvPlant.adapter = adapter
            }

            binding.btnAddNewPlant.setOnClickListener {
                  findNavController().navigate(GardenLogFragmentDirections.actionGardenLogFragmentToAddPlantFragment())
            }
      }

      override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
      }
}