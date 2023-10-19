package com.ihrsachin.apostle.screens.doubt

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.DoubtFragmentBinding
import com.ihrsachin.apostle.sample_data.SubjectData
import com.ihrsachin.apostle.sample_data.TeacherData

class DoubtFragment : Fragment(){

    private lateinit var binding : DoubtFragmentBinding

    val handler = Handler()
    val delayMillis = 300 // Delay in milliseconds

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.doubt_fragment, container, false)




        //// Teacher DropDown
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_list_item, TeacherData.teacherNames)
        (binding.teacherAutoTextview as? AutoCompleteTextView)?.setAdapter(adapter)

        binding.teacherAutoTextview.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has changed.
                if (s.toString().isEmpty()) {
                    // Delay showing the dropdown
                    handler.removeCallbacksAndMessages(null) // Remove any existing callbacks
                    handler.postDelayed({
                        binding.teacherAutoTextview.showDropDown()
                    }, delayMillis.toLong())
                }
                else{
                    handler.removeCallbacksAndMessages(null)  // Remove any existing callbacks
                }
            }
        })




        //// Subject DropDown
        val subjectAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_list_item, SubjectData.subjects)
        (binding.subjectAutoTextview as? AutoCompleteTextView)?.setAdapter(subjectAdapter)

        binding.subjectAutoTextview.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has changed.
                if (s.toString().isEmpty()) {
                    // Delay showing the dropdown
                    handler.removeCallbacksAndMessages(null) // Remove any existing callbacks
                    handler.postDelayed({
                        binding.subjectAutoTextview.showDropDown()
                    }, delayMillis.toLong())
                }
                else{
                    handler.removeCallbacksAndMessages(null)  // Remove any existing callbacks
                }
            }
        })


        return binding.root
    }
}