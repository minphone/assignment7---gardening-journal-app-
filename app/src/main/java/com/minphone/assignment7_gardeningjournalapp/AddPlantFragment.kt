package com.minphone.assignment7_gardeningjournalapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentAddPlantBinding

class AddPlantFragment : Fragment() {

      private var binding: FragmentAddPlantBinding? = null

      override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {
            binding = FragmentAddPlantBinding.inflate(layoutInflater)
            return binding!!.root
      }

      override fun onDestroy() {
            super.onDestroy()
            binding = null
      }

}