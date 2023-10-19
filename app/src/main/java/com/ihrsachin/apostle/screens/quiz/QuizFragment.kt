package com.ihrsachin.apostle.screens.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.databinding.QuizFragmentBinding
import com.ihrsachin.apostle.sample_data.QuestionData

class QuizFragment : Fragment() {

    //data binding
    private lateinit var binding : QuizFragmentBinding


    //adapter and list of questions
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var selectedOptions : IntArray

    //marking scheme
    private val correctAnswerMark = 1f
    private val wrongAnswerMark = -0f
    private val unAttemptedMark = 0f


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // lateinit initialization
        binding = DataBindingUtil.inflate(inflater, R.layout.quiz_fragment, container, false)

        selectedOptions  = IntArray(QuestionData.questionList.size)

        val restaurantLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.layoutManager = restaurantLayoutManager

        questionAdapter = QuestionAdapter(QuestionData.questionList, requireContext(), selectedOptions, false)

        binding.recyclerView.adapter = questionAdapter


        binding.submitBtn.setOnClickListener{
            showDialogue()
        }

        binding.reAttemptBtn.setOnClickListener {
            clearSelection()
            questionAdapter = QuestionAdapter(QuestionData.questionList, requireContext(), selectedOptions, false)
            binding.recyclerView.adapter = questionAdapter
            binding.reAttemptBtn.visibility = View.GONE
            binding.submitBtn.visibility = View.VISIBLE
        }


        return binding.root
    }



    private fun showDialogue(){
        // Create an AlertDialog
        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        // Set the title for the dialog
        alertDialogBuilder.setTitle("Score")

        // Set the message for the dialog
        alertDialogBuilder.setMessage("Your score is ${getScore()}/${QuestionData.questionList.size}")

        // Set a positive button and its click listener
        alertDialogBuilder.setPositiveButton("Re-Attempt") { dialog, which ->

            clearSelection()
            questionAdapter = QuestionAdapter(QuestionData.questionList, requireContext(), selectedOptions, false)
            binding.recyclerView.adapter = questionAdapter


            dialog.dismiss()
        }

        // Set a negative button and its click listener (optional)
        alertDialogBuilder.setNegativeButton("See Answers") { dialog, which ->
            questionAdapter = QuestionAdapter(QuestionData.questionList, requireContext(), selectedOptions, true)
            binding.recyclerView.adapter = questionAdapter

            binding.submitBtn.visibility = View.GONE
            binding.reAttemptBtn.visibility = View.VISIBLE

            dialog.cancel()
        }

        // Create and show the AlertDialog
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun getScore(): Float {
        var score = 0f
        for(i in 0 until QuestionData.questionList.size){
            score += if(selectedOptions[i] == 0){
                unAttemptedMark
            } else if(selectedOptions[i] == QuestionData.questionList[i].correctOption){
                correctAnswerMark
            } else{
                wrongAnswerMark
            }
        }
        return score
    }

    private fun clearSelection(){
        for (i in selectedOptions.indices){
            selectedOptions[i] = 0
        }
    }
}