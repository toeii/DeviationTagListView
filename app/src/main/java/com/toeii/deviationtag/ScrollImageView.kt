package com.toeii.deviationtag

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.WindowManager

class ScrollImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    android.support.v7.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private val height: Int

    init {
        val wm = getContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        height = wm.defaultDisplay.height
    }

    override fun onDraw(canvas: Canvas) {
        val location = IntArray(2)
        getLocationOnScreen(location)
        val y = location[1]
        val drawable = drawable
        val w = width
        val h = (width * 1.0f / drawable.intrinsicWidth * drawable.intrinsicHeight).toInt()
        drawable.setBounds(0, 0, w, h)
        val startH = (height - h) / 2
        val endH = height - startH

        if (y > startH && y < endH - bottom) {
            canvas.translate(0f, (-(y - startH)).toFloat())
        } else if (y >= endH - bottom) {
            canvas.translate(0f, (bottom - h).toFloat())
        }
        super.onDraw(canvas)
        invalidate()
    }
}
