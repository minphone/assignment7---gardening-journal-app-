package com.minphone.assignment7_gardeningjournalapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentPlantDetailsBinding

class PlantDetailsFragment : Fragment() {

      private var _binding: FragmentPlantDetailsBinding? = null
      private val binding get() = _binding!!

      private val args: PlantDetailsFragmentArgs by navArgs()

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

            val plantId = args.plantId
            binding.tvPlantName.text = "Rose"
            binding.tvPlantType.text = "Flower"
            binding.tvPlantingDate.text = "12-12-2023"
            binding.tvWateringFrequency.text = "3 days"
      }

      override fun onDestroy() {
            super.onDestroy()
            _binding = null
      }

}