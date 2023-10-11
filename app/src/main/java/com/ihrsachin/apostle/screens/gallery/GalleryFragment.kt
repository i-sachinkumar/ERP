package com.ihrsachin.apostle.screens.gallery

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.carousel.CarouselLayoutManager
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.GalleryFragmentBinding
import com.ihrsachin.apostle.sample_data
import org.json.JSONException


class GalleryFragment : Fragment() {

    private lateinit var binding: GalleryFragmentBinding

    //

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.gallery_fragment,
            container,
            false
        )

        val carouselAdapter = CarouselAdapter(sample_data.getListImages())
        binding.carouselRecyclerView.layoutManager = CarouselLayoutManager()
        binding.carouselRecyclerView.adapter = carouselAdapter


        // initializing our adapter class.
        val adapter = PictureAdapter(requireActivity(), dataList = sample_data.getPicture())
        // adding layout manager
        // to our recycler view.
        val manager = LinearLayoutManager(requireContext())
        binding.pictureRecyclerView.setHasFixedSize(true)

        // setting layout manager
        // to our recycler view.
        binding.pictureRecyclerView.layoutManager = manager

        // setting adapter to
        // our recycler view.
        binding.pictureRecyclerView.adapter = adapter
        getPictures()

        return binding.root
    }

    private fun getPictures() {
        // creating a new variable for our request queue
        // creating a new variable for our request queue
        val queue = Volley.newRequestQueue(requireActivity())

        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.

        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.
        val jsonArrayRequest =
            JsonArrayRequest(Request.Method.GET, "url goes here", null,
                { response ->
                    for (i in 0 until response.length()) {
                        // creating a new json object and
                        // getting each object from our json array.
                        try {
                            // we are getting each json object.
                            val responseObj = response.getJSONObject(i)

                            // now we get our response from API in json object format.
                            // in below line we are extracting a string with
                            // its key value from our json object.
                            // similarly we are extracting all the strings from our json object.
                            val imgUrl = responseObj.getString("img_url")
                            val title = responseObj.getString("title")
                            val description = responseObj.getString("description")
                            Handler().postDelayed(buildRecyclerView(), 2000)
//                            buildRecyclerView()
                        } catch (e: JSONException) {
                            e.printStackTrace()
                            Handler().postDelayed(buildRecyclerView(), 2000) //TODO
                        }
                    }
                }) {
                Toast.makeText(requireActivity(), "Fail to get the data..", Toast.LENGTH_SHORT)
                    .show()
                Handler().postDelayed(buildRecyclerView(), 2000)
            }
        queue.add(jsonArrayRequest)
    }

    private fun buildRecyclerView(): Runnable {
        return Runnable {
            // on below line we are stopping our shimmer
            // and making its visibility to gone.
            binding.shimmerLayout.stopShimmer()
            binding.shimmerLayout.visibility = View.GONE

            // on below line we are making the
            // recycler view visibility visible.
            binding.pictureRecyclerView.visibility = View.VISIBLE

        }

    }
}