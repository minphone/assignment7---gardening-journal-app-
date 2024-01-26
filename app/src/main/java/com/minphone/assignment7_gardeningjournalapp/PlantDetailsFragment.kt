package com.minphone.assignment7_gardeningjournalapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentPlantDetailsBinding

class PlantDetailsFragment : Fragment() {

      private var binding: FragmentPlantDetailsBinding? = null

      override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {
            binding = FragmentPlantDetailsBinding.inflate(layoutInflater)
            return binding!!.root
      }

      override fun onDestroy() {
            super.onDestroy()
            binding = null
      }

}