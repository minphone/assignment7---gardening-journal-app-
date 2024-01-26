package com.minphone.assignment7_gardeningjournalapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minphone.assignment7_gardeningjournalapp.databinding.FragmentGardenLogBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GardenLogFragment : Fragment() {

      private var binding: FragmentGardenLogBinding? = null

      override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
      ): View {

            binding = FragmentGardenLogBinding.inflate(inflater, container, false)
            return binding!!.root

      }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
      }

      override fun onDestroyView() {
            super.onDestroyView()
            binding = null
      }
}