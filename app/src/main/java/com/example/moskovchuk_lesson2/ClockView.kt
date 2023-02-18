package com.example.moskovchuk_lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import java.lang.Math.min
import java.util.*
import kotlin.math.cos
import kotlin.math.sin

class ClockView(
    context: Context,
    attributeSet: AttributeSet?,
    defStyleAttr: Int =0
): View(context,attributeSet, defStyleAttr) {

    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context) : this(context, null)

    private var mHeight: Int = 0
    private var mWight: Int = 0

    private val mClockHours = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

    private var clockInnerPadding: Int = 0

    private var mRadius: Int = 0

    private var mPaint: Paint = Paint()

    private var isInitialized: Boolean = false

    private val mRect = Rect()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if(!isInitialized) initialize()

        canvas?.scale(0.9f, 0.9f, (mWight/2).toFloat(), (mHeight/2).toFloat())

        drawClockShape(canvas)

        drawNumerals(canvas)

        drawNumerals(canvas)

        drawHands(canvas)

        drawCenterCircle(canvas)

    }

    private fun initialize(){
        mHeight = height
        mWight = width

        val minHeigthWidthValue = min(mHeight,mWight)
        mRadius = (minHeigthWidthValue/2) - clockInnerPadding

        mPaint.isAntiAlias = true
        isInitialized = true
    }

    private fun drawClockShape(canvas: Canvas?){

        mPaint.color = Color.WHITE
        canvas?.drawCircle((mWight/2).toFloat(), (mHeight/2).toFloat(), mRadius.toFloat(), mPaint)

        mPaint.strokeWidth = 5f
        mPaint.style = Paint.Style.STROKE
        mPaint.color = Color.BLACK
        canvas?.drawCircle((mWight/2).toFloat(), (mHeight/2).toFloat(), mRadius.toFloat(), mPaint)

        mPaint.reset()
    }

    private fun drawNumerals(canvas: Canvas?) {
        mPaint.textSize = 2f
        mPaint.isFakeBoldText = true
        mPaint.color = Color.BLACK


        for (hour in mClockHours) {
            var tmp = hour.toString()

            mPaint.getTextBounds(tmp, 0, tmp.length, mRect)
            val angle = Math.PI / 6 * (hour - 3)
            val x = (mWight / 2 + cos(angle) * mRadius - mRect.width() / 2).toFloat()
            val y = ((mHeight / 2).toDouble() + sin(angle) * mRadius + (mRect.height() / 2)).toFloat()

            if (listOf(12, 3, 6, 9).contains(hour)) {
                canvas?.drawText(tmp, x, y, mPaint)
            } else {
                canvas?.drawText("·", x, y, mPaint)
            }
        }
    }

    private fun drawHands(canvas: Canvas?) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR)

        drawHandLine(canvas, (hour + calendar.get(Calendar.MINUTE) / 60f) * 5f, HandType.HOUR)
        drawHandLine(canvas, calendar.get(Calendar.MINUTE).toFloat(), HandType.MINUTE)
        drawHandLine(canvas, calendar.get(Calendar.SECOND).toFloat(), HandType.SECONDS)

        postInvalidateDelayed(500)
        invalidate()

        mPaint.reset()
    }

        private fun drawHandLine(canvas: Canvas?, value: Float, handType: HandType) {
            val angle = Math.PI * value / 30 - Math.PI / 2

            val handRadius = when (handType) {
                HandType.HOUR -> mRadius - mRadius / 3
                HandType.MINUTE -> mRadius - mRadius / 6
                HandType.SECONDS -> mRadius - mRadius / 9
            }
        }

        private fun drawCenterCircle(canvas: Canvas?) {
            mPaint.color = Color.YELLOW
            canvas?.drawCircle(mWight / 2f, mHeight / 2f, 2f, mPaint)
        }

        private enum class HandType { HOUR, MINUTE, SECONDS }


}