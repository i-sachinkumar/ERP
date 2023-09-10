package com.ihrsachin.apostle.screens.change_password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.ChangePasswordFragmentBinding

class ChangePasswordFragment : Fragment() {
    private lateinit var binding: ChangePasswordFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.change_password_fragment,
            container,
            false
        )




        return binding.root
    }
}