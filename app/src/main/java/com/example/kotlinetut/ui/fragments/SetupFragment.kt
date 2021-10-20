package com.example.kotlinetut.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kotlinetut.R
import com.example.kotlinetut.databinding.FragmentSetupBinding

class SetupFragment:Fragment() {
   // R.layout.fragment_setup//

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding= DataBindingUtil.inflate<FragmentSetupBinding>(inflater,
            R.layout.fragment_setup,container,false)
        binding.tvContinue.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        }
        return binding.root
    }
}
