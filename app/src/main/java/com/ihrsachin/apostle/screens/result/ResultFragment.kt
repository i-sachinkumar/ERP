package com.ihrsachin.apostle.screens.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.ResultFragmentBinding

class ResultFragment : Fragment(){

    private lateinit var binding : ResultFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.result_fragment,
            container,
            false)


        return binding.root
    }
}