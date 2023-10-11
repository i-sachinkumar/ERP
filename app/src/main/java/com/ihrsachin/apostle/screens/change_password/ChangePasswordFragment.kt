package com.ihrsachin.apostle.screens.change_password

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.ChangePasswordFragmentBinding
import com.ihrsachin.apostle.model.Credential
import com.ihrsachin.apostle.preference.StudentPreference

class ChangePasswordFragment : Fragment() {
    private lateinit var binding: ChangePasswordFragmentBinding

    private lateinit var studentPreference: StudentPreference

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

        studentPreference = StudentPreference(requireContext())

        binding.originalPasswordVal.addTextChangedListener(textWatcher)
        binding.newPasswordVal.addTextChangedListener(textWatcher)
        binding.confirmNewPasswordVal.addTextChangedListener(textWatcher)


        binding.changePasswordBtn.setOnClickListener{
            val originalPassword = binding.originalPasswordVal.text.toString()
            val newPassword = binding.newPasswordVal.text.toString()
            val confirmNewPassword = binding.confirmNewPasswordVal.text.toString()

            if(newPassword == confirmNewPassword){
                // check if old one is correct
                val tester1 = Gson().fromJson(studentPreference.get(getString(R.string.tester_1)), Credential::class.java)
                if(tester1.password == originalPassword){
                    //change password now
                    tester1.password = newPassword
                    studentPreference.update(getString(R.string.tester_1), Gson().toJson(tester1))
                    studentPreference.remove(getString(R.string.current_user))
                    findNavController().navigate(R.id.action_change_password_fragment_to_login_page_fragment)
                }
                else{
                    //original password is incorrect
                    binding.originalPasswordWrap.error = "original password is incorrect"
                }
            }
            else{
                binding.confirmNewPasswordWrap.error = "confirm password is not matching to new password"
            }
        }




        return binding.root
    }

    // Define a TextWatcher
    val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // This method is called before the text is changed
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // This method is called as the text is changing
            binding.newPasswordWrap.isErrorEnabled = false
            binding.confirmNewPasswordWrap.isErrorEnabled = false
            binding.originalPasswordWrap.isErrorEnabled = false
            // Perform actions based on the entered text
        }

        override fun afterTextChanged(s: Editable?) {
            // This method is called after the text has changed
        }
    }
}