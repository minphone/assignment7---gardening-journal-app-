package com.minphone.assignment7_gardeningjournalapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.minphone.assignment7_gardeningjournalapp.adapter.AdapterClickListener
import com.minphone.assignment7_gardeningjournalapp.adapter.PlantRecyclerAdapter
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentGardenLogBinding
import com.minphone.assignment7_gardeningjournalapp.model.Plant

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GardenLogFragment : Fragment() {

      private var _binding: FragmentGardenLogBinding? = null
      private val binding get() = _binding!!


      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {
            _binding = FragmentGardenLogBinding.inflate(inflater, container, false)
            return binding.root

      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val samplePlants = mutableListOf<Plant>()

            // Add sample plants
            samplePlants.add(
                  Plant(
                        id = 100,
                        name = "Rose",
                        type = "Flower",
                        wateringFrequency = 2,
                        plantingDate = "2023-01-01"
                  )
            )
            samplePlants.add(
                  Plant(
                        id = 101,
                        name = "Tomato",
                        type = "Vegetable",
                        wateringFrequency = 3,
                        plantingDate = "2023-02-15"
                  )
            )
            samplePlants.add(
                  Plant(
                        id = 102,
                        name = "Basil",
                        type = "Herb",
                        wateringFrequency = 1,
                        plantingDate = "2023-03-10"
                  )
            )

            val adapter = PlantRecyclerAdapter(samplePlants, object : AdapterClickListener {
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

      override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
      }
}