package com.starwars.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import com.starwars.R

@Suppress("MemberVisibilityCanBePrivate", "unused")
class ImageViewRounded : LinearLayout {
    val view: View? by lazy { View.inflate(context, R.layout.custom_image_view_rounded, this) }
    private val cardView: CardView? by lazy { view?.findViewById<CardView>(R.id.cardViewCustomRounded) }
    val imageView: ImageView? by lazy { view?.findViewById<ImageView>(R.id.imageViewCustomRounded) }
    var radius: Float = 0.0f
        set(value) {
            field = value
            cardView?.radius = value
        }
        get() = cardView?.radius ?: 0.0f
    private var attrs: AttributeSet? = null
        set(value) {
            field = value
            initView()
        }

    constructor(context: Context) : super(context) {
        attrs = null
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.attrs = attrs
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.attrs = attrs
    }

    private fun initView() {
        if (attrs == null) return
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.ImageViewRounded)
        val src = typeArray.getDrawable(R.styleable.ImageViewRounded_android_src)
        val radius = typeArray.getDimension(R.styleable.ImageViewRounded_radius, this.radius)
        src?.let { imageView?.setImageDrawable(it) }
        this.radius = radius
        cardView?.radius = radius
        typeArray.recycle()
    }

    fun setOnClickListener(onClick: (View) -> Unit) = cardView?.setOnClickListener { onClick(it) }

    fun setOnLongClickListener(onLongClick: (View) -> Unit) = cardView?.setOnLongClickListener {
        onLongClick(it)
        true
    }

}