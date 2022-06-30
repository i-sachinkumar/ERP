package com.ihrsachin.apostle.custom_views


import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.ihrsachin.apostle.R

class HomePageCard : ConstraintLayout {

    var mainImageView: ImageView
    private var iconImageView: ImageView
    var caption : TextView

    constructor(context: Context) : super(context){
        mainImageView = findViewById(R.id.image)
        iconImageView = findViewById(R.id.icon)
        caption = findViewById(R.id.caption)
    }

    constructor(context: Context, attrs : AttributeSet) : super(context, attrs) {
        inflate(context, R.layout.homepage_card, this)
        val attrs1 = context.obtainStyledAttributes(attrs, R.styleable.homepage_card)
        mainImageView = findViewById(R.id.image)
        iconImageView = findViewById(R.id.icon)
        caption = findViewById(R.id.caption)

        mainImageView.setImageResource(attrs1.getResourceId(R.styleable.homepage_card_img_src,
            R.color.teal_200))
        if(attrs1.getBoolean(R.styleable.homepage_card_is_icon_visible,false)){
            iconImageView.visibility = VISIBLE
        }
        else iconImageView.visibility = GONE

        caption.text = attrs1.getString(R.styleable.homepage_card_caption)
    }

}


//class InfoBox :ConstraintLayout {
//    var imageView: ImageView? = null
//    var textView1: TextView? = null
//    var textView2: TextView? = null
//
//
//    constructor(context: Context) : super(context) {
//    }
//
//    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
//        View.inflate(context, R.layout.custom_item, this)
//        @SuppressLint("Recycle") val attrs1 =
//            context.obtainStyledAttributes(attrs, R.styleable.InfoBox)
//        imageView = findViewById<ImageView>(R.id.imageView)
//        imageView!!.setBackgroundColor(getResources().getColor(R.color.teal_700))
//        imageView!!.setImageResource(attrs1.getResourceId(R.styleable.InfoBox_android_src,
//            R.color.white))
//        textView1 = findViewById<TextView>(R.id.text)
//        textView1!!.text = attrs1.getText(R.styleable.InfoBox_text_heading)
//        textView2 = findViewById<TextView>(R.id.text2)
//        textView2!!.text = attrs1.getText(R.styleable.InfoBox_text_desc)
//    }
//}
