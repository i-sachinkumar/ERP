package com.ihrsachin.apostle.screens.login_page

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ihrsachin.apostle.MainViewModel
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.LoginPageFragmentBinding
import com.ihrsachin.apostle.model.Credential
import com.ihrsachin.apostle.preference.StudentPreference


class LoginPageFragment : Fragment() {
    private lateinit var binding: LoginPageFragmentBinding
    private lateinit var viewModel: LoginPageViewModel

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    private lateinit var mainViewModel: MainViewModel

    private lateinit var studentPreference: StudentPreference

    private lateinit var tester1Credential : Credential

    private lateinit var gson : Gson


    override fun onStop() {
        super.onStop()
//        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        mainViewModel.mDrawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
//        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        mainViewModel.mDrawerLayout!!.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
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

        // initialize
        studentPreference = StudentPreference(requireContext())
        gson = Gson()

        binding.stuParentLoginBtn.setOnClickListener {
            val userId : String = binding.usernameVal.text.toString()
            val password : String = binding.passwordVal.text.toString()
            val currentCredential = Credential(userId = userId, password = password)
            val currentCredentialJson = gson.toJson(currentCredential)
            if(currentCredentialJson.equals(gson.toJson(tester1Credential))){
                studentPreference.add(getString(R.string.current_user), currentCredentialJson)
                gotoHomePage()
            }
            else{
                Toast.makeText(requireContext(), "Either User Id or Password is wrong", Toast.LENGTH_SHORT).show()
            }
        }

        // if already login credential is saved
        if(studentPreference.contains(getString(R.string.current_user))){
            println("..........${studentPreference.get(getString(R.string.current_user))}")
            gotoHomePage()
        }

        addTester()

        return binding.root
    }

    private fun addTester(){
        if(studentPreference.contains(getString(R.string.tester_1))){
            tester1Credential = gson.fromJson(studentPreference.get(getString(R.string.tester_1)), Credential::class.java)
        }
        else{
            tester1Credential = Credential("tester1", "tester1@123")
            val credentialJson = gson.toJson(tester1Credential)
            studentPreference.add(getString(R.string.tester_1), credentialJson)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginPage = this
    }

    private fun gotoHomePage() {
        val extras = FragmentNavigatorExtras(
            binding.hiStudent to "hi_student_home",
            binding.signInToContinue to "class_roll_home",
            binding.icons to "profile_pic_home",
//            binding.usernameText to "attendance_card_home",
//            binding.passwordText to "fee_due_card_home",
            binding.foregroundLogin to "foreground_home"
        )
        findNavController().navigate(
            R.id.action_login_page_fragment_to_home_page_fragment,
            null,
            null,
            extras
        )
    }
}