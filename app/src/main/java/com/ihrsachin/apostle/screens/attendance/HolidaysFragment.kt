package com.ihrsachin.apostle.screens.attendance

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.HolidaysFragmentBinding
import kotlin.math.roundToInt


class HolidaysFragment : Fragment() {

    private lateinit var binding : HolidaysFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.holidays_fragment, container, false)


        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels
        val tabLayoutHeight = dpToPx(requireContext(), 50)

        println("sc : $screenHeight, t: $tabLayoutHeight")

        val parentLayout = binding.parent  // Reference to your ConstraintLayout

        parentLayout.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // Remove the listener to avoid multiple calls
                parentLayout.viewTreeObserver.removeOnGlobalLayoutListener(this)

                // Get the accurate height of the parentLayout
                val parentHeightWithBottom = parentLayout.height

                if (tabLayoutHeight + parentHeightWithBottom >= screenHeight) {
                    // Your condition if the layout exceeds the screen height
                } else {
                    val params = binding.bottomDesign.layoutParams as ViewGroup.MarginLayoutParams
                    params.topMargin = screenHeight - parentHeightWithBottom - tabLayoutHeight
                    binding.bottomDesign.layoutParams = params
                }
            }
        })

        return binding.root
    }

    fun dpToPx(context: Context, dp: Int): Int {
        val density = context.resources.displayMetrics.density
        return (dp * density).roundToInt()
    }
}