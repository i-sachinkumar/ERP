package com.ihrsachin.apostle.screens.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.EventFragmentBinding
import com.ihrsachin.apostle.sample_data.EventData

class EventFragment : Fragment() {

    private lateinit var binding : EventFragmentBinding
    private lateinit var eventAdapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.event_fragment, container, false)

        val restaurantLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = restaurantLayoutManager

        eventAdapter = EventAdapter(dataList = EventData.events)

        binding.recyclerView.adapter = eventAdapter


        return binding.root
    }
}