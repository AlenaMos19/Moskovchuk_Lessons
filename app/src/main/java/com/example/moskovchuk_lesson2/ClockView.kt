package com.example.moskovchuk_lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Math.min

class ClockView(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr: Int =0
): View(context,attributeSet, defStyleAttr) {

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null)

    private var mHeight: Int = 0
    private var mWight: Int = 0


    private var clockInnerPadding: Int = 0

    private var mRadius: Int = 0

    private var mPaint: Paint = Paint()

    private var isInitialized: Boolean = false


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (!isInitialized) initialize()

        canvas?.scale(0.9f, 0.9f, (mWight / 2).toFloat(), (mHeight / 2).toFloat())

        drawClockShape(canvas)

    }

    private fun initialize() {
        mHeight = height
        mWight = width

        val minHeigthWidthValue = min(mHeight, mWight)
        mRadius = (minHeigthWidthValue / 2) - clockInnerPadding

        mPaint.isAntiAlias = true
        isInitialized = true
    }

    private fun drawClockShape(canvas: Canvas?) {

        mPaint.color = Color.WHITE
        canvas?.drawCircle(
            (mWight / 2).toFloat(),
            (mHeight / 2).toFloat(),
            mRadius.toFloat(),
            mPaint
        )

        mPaint.strokeWidth = 5f
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLACK
        canvas?.drawCircle(
            (mWight / 2).toFloat(),
            (mHeight / 2).toFloat(),
            mRadius.toFloat(),
            mPaint
        )

        mPaint.reset()
    }

}