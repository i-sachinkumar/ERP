package com.ihrsachin.apostle.screens.fee

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.FeeFragmentBinding


class FeeFragment : Fragment() {

    private lateinit var binding: FeeFragmentBinding
    private lateinit var viewModel: FeeViewModel

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        //return super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fee_fragment,
            container,
            false
        )
//
//        binding.zoomLinearLayout.setOnTouchListener { _, _ ->
//            binding.zoomLinearLayout.init(requireContext())
//            false
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.feePage = this
    }

}