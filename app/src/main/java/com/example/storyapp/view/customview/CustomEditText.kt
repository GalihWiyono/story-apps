package com.example.storyapp.view.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.example.storyapp.R

class CustomEditText : AppCompatEditText{

    private var errorBackground : Drawable? = null
    private var defaultBackground : Drawable? = null
    var errorCheck : Boolean = false

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        defaultBackground = ContextCompat.getDrawable(context, R.drawable.bg_edittext)
        errorBackground = ContextCompat.getDrawable(context, R.drawable.bg_edittext_error)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = when {
            errorCheck -> errorBackground
            else -> defaultBackground
        }
    }

}