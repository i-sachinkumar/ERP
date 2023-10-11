package com.ihrsachin.apostle.screens.homepage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.HomePageFragmentBinding
import com.ihrsachin.apostle.permissions.StoragePermission
import com.ihrsachin.apostle.preference.StudentPreference

class HomePageFragment : Fragment(){

    private lateinit var binding: HomePageFragmentBinding
    private lateinit var viewModel: HomePageViewModel

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private lateinit var storagePermission: StoragePermission
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
        storagePermission = StoragePermission(requireContext())


        binding.profilePic.setOnClickListener{
            val extras = FragmentNavigatorExtras(
                binding.hiStudentName to "go_back_btn_profile",
                binding.session to "done_button_profile",
                binding.profilePic to "profile_pic_profile",
                binding.bottomPart to "foreground_profile"
            )
            findNavController().navigate(
                R.id.action_home_page_fragment_to_profile_fragment,
            null,
            null,
            extras)
        }


        binding.timeTable.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_fragment_to_time_table_fragment)
        }

        binding.attendanceCard.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_fragment_to_attendance_fragment)
        }

        binding.gallery.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_fragment_to_gallery_fragment)
        }

        binding.result.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_fragment_to_result_fragment)
        }

        binding.changePassword.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_fragment_to_change_password_fragment)
        }
        binding.feeDue.setOnClickListener {
            findNavController().navigate(R.id.action_home_page_fragment_to_fee_fragment)
        }

        binding.logout.setOnClickListener {
            StudentPreference(requireContext()).remove(getString(R.string.current_user))
            findNavController().navigate(R.id.action_home_page_fragment_to_login_page_fragment)
        }

//        binding.run {
//            attendanceIcon.setOnClickListener{
//                findNavController().navigate(R.id.action_home_page_fragment_to_attendance_fragment)
//            }
//            feeIcon.setOnClickListener{
//                findNavController().navigate(R.id.action_home_page_fragment_to_fee_fragment)
//            }
//            profileIcon.setOnClickListener{
//                findNavController().navigate(R.id.action_home_page_fragment_to_profile_fragment)
//            }
//            profilePic.setOnClickListener {
//                findNavController().navigate(R.id.action_home_page_fragment_to_profile_fragment)
//            }
//            item4.setOnClickListener{
//                //findNavController().navigate(R.id.)
//                Toast.makeText(context, "clicked",Toast.LENGTH_SHORT).show()
//            }
//            item5.setOnClickListener{
//                //findNavController().navigate(R.id.)
//                Toast.makeText(context, "clicked",Toast.LENGTH_SHORT).show()
//            }
//            item6.setOnClickListener{
//                //findNavController().navigate(R.id.)
//                Toast.makeText(context, "clicked",Toast.LENGTH_SHORT).show()
//            }
//        }


        // Display name can be changed
//        viewModel.name.observe(viewLifecycleOwner) {
//            binding.name.text = it
//        }
//
//
//        // display profile can be changed
//        viewModel.profilePicUri.observe(viewLifecycleOwner){
//            binding.dp.setImageURI(viewModel.profilePicUri.value)
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homePage = this
    }

}