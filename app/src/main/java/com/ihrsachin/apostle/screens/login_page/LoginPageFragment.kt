package com.ihrsachin.apostle.screens.login_page

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ihrsachin.apostle.MainViewModel
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.LoginPageFragmentBinding


class LoginPageFragment : Fragment(){
    private lateinit var binding: LoginPageFragmentBinding
    private lateinit var viewModel: LoginPageViewModel

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    lateinit var mainViewModel: MainViewModel

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        mainViewModel.mDrawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        mainViewModel.mDrawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }

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
            R.layout.login_page_fragment,
            container,
            false
        )

        binding.stuParentLoginBtn.setOnClickListener{
            gotoHomePage()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginPage = this
    }

    private fun gotoHomePage(){
        findNavController().navigate(R.id.action_login_page_fragment_to_home_page_fragment)
    }
}