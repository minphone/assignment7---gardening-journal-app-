package com.minphone.assignment7_gardeningjournalapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentAddPlantBinding
import com.minphone.assignment7_gardeningjournalapp.model.Plant
import com.minphone.assignment7_gardeningjournalapp.viewModel.AddPlantViewModel

class AddPlantFragment : Fragment() {

      private var _binding: FragmentAddPlantBinding? = null
      private val binding get() = _binding!!

      private lateinit var viewModel: AddPlantViewModel

      override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {
            _binding = FragmentAddPlantBinding.inflate(layoutInflater)
            return binding.root
      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this)[AddPlantViewModel::class.java]

            binding.btnAddPlant.setOnClickListener {
                  viewModel.addPlant(
                        Plant(
                              id = 0,
                              name = binding.etPlantName.text.toString(),
                              type = binding.etPlantType.text.toString(),
                              wateringFrequency = binding.etWateringFrequency.text.toString().toInt(),
                              plantingDate = binding.etPlantingDate.text.toString()
                        )
                  )
                  findNavController().navigate(AddPlantFragmentDirections.actionAddPlantFragmentToGardenLogFragment())
            }
      }

      override fun onDestroy() {
            super.onDestroy()
            _binding = null
      }

}