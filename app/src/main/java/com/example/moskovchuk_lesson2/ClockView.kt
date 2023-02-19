package com.example.moskovchuk_lesson2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.core.content.ContextCompat
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

    private var clockInnerPadding: Int = 0

    private var mRadius: Int = 0

    private var mPaint: Paint = Paint()

    private var isInitialized: Boolean = false

    private val handSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4f, context.resources.displayMetrics)

    private var borderColor = ContextCompat.getColor(context, R.color.defaultBorderColor)
    private var hourHandsColor = ContextCompat.getColor(context, R.color.defaultHourHandsColor)
    private var minHandsColor = ContextCompat.getColor(context, R.color.defaultMinHandsColor)
    private var secondsHandColor = ContextCompat.getColor(context, R.color.defaultSecondsHandsColor)

    init {
        setUpAttributes(attributeSet)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if(!isInitialized) initialize()

        canvas?.scale(0.9f, 0.9f, (mWight/2).toFloat(), (mHeight/2).toFloat())

        drawClockShape(canvas)

        drawHands(canvas)
    }

    fun setBorderColor(value: Int) {
        borderColor = ContextCompat.getColor(context, value)
    }

    fun setMinHandsColor(value: Int) {
        minHandsColor = ContextCompat.getColor(context, value)
    }
    fun setHourHandsColor(value: Int) {
        hourHandsColor = ContextCompat.getColor(context, value)
    }

    fun setSecondsHandColor(value: Int) {
        secondsHandColor = ContextCompat.getColor(context, value)
    }
    private fun setUpAttributes(attributes: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attributes, R.styleable.ClockView, 0, 0)

        borderColor = ContextCompat.getColor(context, typedArray.getResourceId(R.styleable.ClockView_borderColor, R.color.defaultBorderColor))
        minHandsColor = ContextCompat.getColor(context, typedArray.getResourceId(R.styleable.ClockView_minHandsColor, R.color.defaultMinHandsColor))
        hourHandsColor = ContextCompat.getColor(context, typedArray.getResourceId(R.styleable.ClockView_hourHandsColor, R.color.defaultHourHandsColor))
        secondsHandColor = ContextCompat.getColor(context, typedArray.getResourceId(R.styleable.ClockView_secondsHandColor, R.color.defaultSecondsHandsColor))

        typedArray.recycle()
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
            mPaint.color =
                when (handType)
                {HandType.SECONDS -> secondsHandColor
                 HandType.HOUR -> hourHandsColor
                    else -> {minHandsColor}
                }
            mPaint.strokeWidth = if (handType == HandType.SECONDS) handSize else handSize * 2
            mPaint.strokeCap = Paint.Cap.ROUND

            canvas?.drawLine(
                (mWight / 2).toFloat(),
                (mHeight / 2).toFloat(),
                (mWight / 2 + cos(angle) * handRadius).toFloat(),
                (mHeight / 2 + sin(angle) * handRadius).toFloat(),
                mPaint
            )
        }

        private enum class HandType { HOUR, MINUTE, SECONDS }
}