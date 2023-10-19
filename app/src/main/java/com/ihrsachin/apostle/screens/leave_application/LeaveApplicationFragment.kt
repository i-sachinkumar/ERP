package com.ihrsachin.apostle.screens.leave_application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.LeaveApplicationFragmentBinding

class LeaveApplicationFragment : Fragment() {

    private lateinit var binding : LeaveApplicationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.leave_application_fragment, container, false)


        return binding.root
    }
}