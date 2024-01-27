package com.minphone.assignment7_gardeningjournalapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentPlantDetailsBinding
import com.minphone.assignment7_gardeningjournalapp.viewModel.PlantDetailsViewModel

class PlantDetailsFragment : Fragment() {

      private var _binding: FragmentPlantDetailsBinding? = null
      private val binding get() = _binding!!

      private val args: PlantDetailsFragmentArgs by navArgs()

      private lateinit var viewModel: PlantDetailsViewModel

      override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {
            _binding = FragmentPlantDetailsBinding.inflate(layoutInflater)
            return binding.root
      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this)[PlantDetailsViewModel::class.java]

            val plantId = args.plantId
            viewModel.getPlantById(plantId)

            viewModel.plant.observe(viewLifecycleOwner){plant ->
                  binding.tvPlantName.text = plant.name
                  binding.tvPlantType.text = plant.type
                  binding.tvPlantingDate.text = plant.plantingDate
                  binding.tvWateringFrequency.text = "${plant.wateringFrequency} days"
            }
      }

      override fun onDestroy() {
            super.onDestroy()
            _binding = null
      }

}