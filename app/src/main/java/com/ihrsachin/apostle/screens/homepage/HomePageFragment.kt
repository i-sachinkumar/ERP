package com.ihrsachin.apostle.screens.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.HomePageFragmentBinding

class HomePageFragment : Fragment(){

    private lateinit var binding: HomePageFragmentBinding
    private lateinit var viewModel: HomePageViewModel

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.home_page_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this)[HomePageViewModel::class.java]


        binding.run {
            attendanceIcon.setOnClickListener{
                findNavController().navigate(R.id.action_home_page_fragment_to_attendance_fragment)
            }
            feeIcon.setOnClickListener{
                findNavController().navigate(R.id.action_home_page_fragment_to_fee_fragment)
            }
            profileIcon.setOnClickListener{
                findNavController().navigate(R.id.action_home_page_fragment_to_profile_fragment)
            }
            item4.setOnClickListener{
                //findNavController().navigate(R.id.)
                Toast.makeText(context, "clicked",Toast.LENGTH_SHORT).show()
            }
            item5.setOnClickListener{
                //findNavController().navigate(R.id.)
                Toast.makeText(context, "clicked",Toast.LENGTH_SHORT).show()
            }
            item6.setOnClickListener{
                //findNavController().navigate(R.id.)
                Toast.makeText(context, "clicked",Toast.LENGTH_SHORT).show()
            }
        }


        // Display name can be changed
        viewModel.name.observe(viewLifecycleOwner) {
            binding.name.text = it
        }


        // display profile can be changed
        viewModel.profilePicUri.observe(viewLifecycleOwner){
            binding.dp.setImageURI(viewModel.profilePicUri.value)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homePage = this
    }

}