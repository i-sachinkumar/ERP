package com.ihrsachin.apostle.screens.quiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.ihrsachin.apostle.R
import com.ihrsachin.apostle.model.Question

class QuestionAdapter(
    private var dataList: List<Question>,
    private var context: Context,
    private val selectedOption: IntArray,
    private val isSubmitted: Boolean
) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionNo: TextView = itemView.findViewById(R.id.question_no)

        val question: TextView = itemView.findViewById(R.id.question)

        // Option 1
        val option1Wrap: MaterialCardView = itemView.findViewById(R.id.option1_wrap)
        val option1Text: TextView = itemView.findViewById(R.id.option1_text)
        val option1CheckBox: MaterialCardView = itemView.findViewById(R.id.option1_check_box)
        val checkBox1Bg: View = itemView.findViewById(R.id.checkbox1_bg)


        // Option 2
        val option2Wrap: MaterialCardView = itemView.findViewById(R.id.option2_wrap)
        val option2Text: TextView = itemView.findViewById(R.id.option2_text)
        val option2CheckBox: MaterialCardView = itemView.findViewById(R.id.option2_check_box)
        val checkBox2Bg: View = itemView.findViewById(R.id.checkbox2_bg)


        // Option 3
        val option3Wrap: MaterialCardView = itemView.findViewById(R.id.option3_wrap)
        val option3Text: TextView = itemView.findViewById(R.id.option3_text)
        val option3CheckBox: MaterialCardView = itemView.findViewById(R.id.option3_check_box)
        val checkBox3Bg: View = itemView.findViewById(R.id.checkbox3_bg)


        // Option 4
        val option4Wrap: MaterialCardView = itemView.findViewById(R.id.option4_wrap)
        val option4Text: TextView = itemView.findViewById(R.id.option4_text)
        val option4CheckBox: MaterialCardView = itemView.findViewById(R.id.option4_check_box)
        val checkBox4Bg: View = itemView.findViewById(R.id.checkbox4_bg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.question_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = dataList[position]

        holder.questionNo.text = "Question ${position + 1}/${dataList.size}"
        holder.question.text = question.question

        // option 1
        holder.option1Text.text = "A. ${question.option1}"

        // option 2
        holder.option2Text.text = "B. ${question.option2}"

        // option 3
        holder.option3Text.text = "C. ${question.option3}"

        // option 4
        holder.option4Text.text = "D. ${question.option4}"

        clearDesignAll(holder)
        if (!isSubmitted){
            markSelected(
                holder = holder,
                option = selectedOption[position],
                position = position
            )

            // handle selections
            holder.option1Wrap.setOnClickListener {
                clearDesignAll(holder = holder)
                markSelected(holder = holder, option = 1, position = position)
            }
            holder.option2Wrap.setOnClickListener {
                clearDesignAll(holder = holder)
                markSelected(holder = holder, option = 2, position = position)
            }
            holder.option3Wrap.setOnClickListener {
                clearDesignAll(holder = holder)
                markSelected(holder = holder, option = 3, position = position)
            }
            holder.option4Wrap.setOnClickListener {
                clearDesignAll(holder = holder)
                markSelected(holder = holder, option = 4, position = position)
            }
        }
        else {
            markWrong(holder = holder, option = selectedOption[position])
            markCorrect(holder, option = question.correctOption)
        }

    }

    private fun clearDesignAll(holder: ViewHolder) {
        // option 1
        holder.option1Wrap.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option1Wrap.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option1Wrap.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()

        holder.option1Text.setTextColor(context.resources.getColor(R.color.normal_text_color))

        holder.option1CheckBox.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option1CheckBox.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option1CheckBox.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
        holder.checkBox1Bg.background = context.resources.getDrawable(R.drawable.normal_ans_bg)


        // option 2
        holder.option2Wrap.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option2Wrap.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option2Wrap.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()

        holder.option2Text.setTextColor(context.resources.getColor(R.color.normal_text_color))

        holder.option2CheckBox.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option2CheckBox.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option2CheckBox.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
        holder.checkBox2Bg.background = context.resources.getDrawable(R.drawable.normal_ans_bg)


        // option 3
        holder.option3Wrap.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option3Wrap.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option3Wrap.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()

        holder.option3Text.setTextColor(context.resources.getColor(R.color.normal_text_color))

        holder.option3CheckBox.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option3CheckBox.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option3CheckBox.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
        holder.checkBox3Bg.background = context.resources.getDrawable(R.drawable.normal_ans_bg)


        // option 4
        holder.option4Wrap.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option4Wrap.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option4Wrap.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()

        holder.option4Text.setTextColor(context.resources.getColor(R.color.normal_text_color))

        holder.option4CheckBox.setCardBackgroundColor(context.resources.getColor(R.color.normal_background_color))
        holder.option4CheckBox.strokeColor = context.resources.getColor(R.color.normal_stroke_color)
        holder.option4CheckBox.strokeWidth =
            context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
        holder.checkBox4Bg.background = context.resources.getDrawable(R.drawable.normal_ans_bg)

    }


    private fun markSelected(holder: ViewHolder, option: Int, position: Int) {
        selectedOption[position] = option
        // option 1
        when (option) {
            1 -> {
                holder.option1Wrap.setCardBackgroundColor(context.resources.getColor(R.color.selected_background_color))
                holder.option1Wrap.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option1Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option1Text.setTextColor(context.resources.getColor(R.color.selected_text_color))


                holder.option1CheckBox.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option1CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox1Bg.background =
                    context.resources.getDrawable(R.drawable.selected_ans_bg)
            }

            // option 2
            2 -> {
                holder.option2Wrap.setCardBackgroundColor(context.resources.getColor(R.color.selected_background_color))
                holder.option2Wrap.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option2Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option2Text.setTextColor(context.resources.getColor(R.color.selected_text_color))


                holder.option2CheckBox.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option2CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox2Bg.background =
                    context.resources.getDrawable(R.drawable.selected_ans_bg)
            }

            // option 3
            3 -> {
                holder.option3Wrap.setCardBackgroundColor(context.resources.getColor(R.color.selected_background_color))
                holder.option3Wrap.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option3Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option3Text.setTextColor(context.resources.getColor(R.color.selected_text_color))


                holder.option3CheckBox.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option3CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox3Bg.background =
                    context.resources.getDrawable(R.drawable.selected_ans_bg)
            }

            // option 4
            4 -> {
                holder.option4Wrap.setCardBackgroundColor(context.resources.getColor(R.color.selected_background_color))
                holder.option4Wrap.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option4Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option4Text.setTextColor(context.resources.getColor(R.color.selected_text_color))


                holder.option4CheckBox.strokeColor =
                    context.resources.getColor(R.color.selected_stroke_color)
                holder.option4CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox4Bg.background =
                    context.resources.getDrawable(R.drawable.selected_ans_bg)
            }
        }
    }


    private fun markCorrect(holder: ViewHolder, option: Int) {
        // option 1
        when (option) {
            1 -> {
                holder.option1Wrap.setCardBackgroundColor(context.resources.getColor(R.color.correct_background_color))
                holder.option1Wrap.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option1Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option1Text.setTextColor(context.resources.getColor(R.color.correct_text_color))

                holder.option1CheckBox.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option1CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox1Bg.background =
                    context.resources.getDrawable(R.drawable.correct_ans_bg)
            }

            // option 2
            2 -> {
                holder.option2Wrap.setCardBackgroundColor(context.resources.getColor(R.color.correct_background_color))
                holder.option2Wrap.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option2Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option2Text.setTextColor(context.resources.getColor(R.color.correct_text_color))

                holder.option2CheckBox.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option2CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox2Bg.background =
                    context.resources.getDrawable(R.drawable.correct_ans_bg)
            }

            // option 3
            3 -> {
                holder.option3Wrap.setCardBackgroundColor(context.resources.getColor(R.color.correct_background_color))
                holder.option3Wrap.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option3Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option3Text.setTextColor(context.resources.getColor(R.color.correct_text_color))

                holder.option3CheckBox.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option3CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox3Bg.background =
                    context.resources.getDrawable(R.drawable.correct_ans_bg)
            }

            // option 4
            4 -> {
                holder.option4Wrap.setCardBackgroundColor(context.resources.getColor(R.color.correct_background_color))
                holder.option4Wrap.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option4Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option4Text.setTextColor(context.resources.getColor(R.color.correct_text_color))

                holder.option4CheckBox.strokeColor =
                    context.resources.getColor(R.color.correct_stroke_color)
                holder.option4CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox4Bg.background =
                    context.resources.getDrawable(R.drawable.correct_ans_bg)
            }
        }
    }


    private fun markWrong(holder: ViewHolder, option: Int) {
        // option 1
        when (option) {
            1 -> {
                holder.option1Wrap.setCardBackgroundColor(context.resources.getColor(R.color.wrong_background_color))
                holder.option1Wrap.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option1Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option1Text.setTextColor(context.resources.getColor(R.color.wrong_text_color))

                holder.option1CheckBox.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option1CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox1Bg.background =
                    context.resources.getDrawable(R.drawable.wrong_ans_bg)
            }

            // option 2
            2 -> {
                holder.option2Wrap.setCardBackgroundColor(context.resources.getColor(R.color.wrong_background_color))
                holder.option2Wrap.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option2Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option2Text.setTextColor(context.resources.getColor(R.color.wrong_text_color))

                holder.option2CheckBox.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option2CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox2Bg.background =
                    context.resources.getDrawable(R.drawable.wrong_ans_bg)
            }

            // option 3
            3 -> {
                holder.option3Wrap.setCardBackgroundColor(context.resources.getColor(R.color.wrong_background_color))
                holder.option3Wrap.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option3Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option3Text.setTextColor(context.resources.getColor(R.color.wrong_text_color))

                holder.option3CheckBox.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option3CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox3Bg.background =
                    context.resources.getDrawable(R.drawable.wrong_ans_bg)
            }

            // option 4
            4 -> {
                holder.option4Wrap.setCardBackgroundColor(context.resources.getColor(R.color.wrong_background_color))
                holder.option4Wrap.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option4Wrap.strokeWidth =
                    context.resources.getDimension(R.dimen.thick_stroke_width).toInt()

                holder.option4Text.setTextColor(context.resources.getColor(R.color.wrong_text_color))

                holder.option4CheckBox.strokeColor =
                    context.resources.getColor(R.color.wrong_stroke_color)
                holder.option4CheckBox.strokeWidth =
                    context.resources.getDimension(R.dimen.normal_stroke_width).toInt()
                holder.checkBox4Bg.background =
                    context.resources.getDrawable(R.drawable.wrong_ans_bg)
            }
        }
    }


}