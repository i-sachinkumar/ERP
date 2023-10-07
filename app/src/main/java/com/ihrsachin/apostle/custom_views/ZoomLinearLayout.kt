package com.ihrsachin.apostle.custom_views

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.LinearLayout

class ZoomLinearLayout : LinearLayout, ScaleGestureDetector.OnScaleGestureListener {
    private enum class Mode {
        NONE, DRAG, ZOOM
    }

    private var mode = Mode.NONE
    private var scale = 1.0f
    private var lastScaleFactor = 0f
    private var startX = 0f
    private var startY = 0f
    private var dx = 0f
    private var dy = 0f
    private var prevDx = 0f
    private var prevDy = 0f
    private var gestureDetector: GestureDetector? = null
    private var zoomAnimator: ValueAnimator? = null
    private var zoomCenterX = 0f
    private var zoomCenterY = 0f

    constructor(context: Context?) : super(context) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(context)
    }

    fun init(context: Context?) {
        val scaleDetector = ScaleGestureDetector(context!!, this)
        gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onDoubleTap(e: MotionEvent): Boolean {
                // Toggle between zoom in and zoom out on double-tap
                val targetScale = if (scale == 1.0f) MAX_ZOOM else 1.0f
                zoomTo(targetScale, e.x, e.y)
                return true
            }
        })

        setOnTouchListener { _, motionEvent ->
            gestureDetector?.onTouchEvent(motionEvent)
            when (motionEvent.action and MotionEvent.ACTION_MASK) {
                MotionEvent.ACTION_DOWN -> if (scale > MIN_ZOOM) {
                    mode = Mode.DRAG
                    startX = motionEvent.x - prevDx
                    startY = motionEvent.y - prevDy
                }

                MotionEvent.ACTION_MOVE -> if (mode == Mode.DRAG) {
                    dx = motionEvent.x - startX
                    dy = motionEvent.y - startY
                }

                MotionEvent.ACTION_POINTER_DOWN -> mode = Mode.ZOOM
                MotionEvent.ACTION_POINTER_UP -> mode = Mode.DRAG
                MotionEvent.ACTION_UP -> {
                    mode = Mode.NONE
                    prevDx = dx
                    prevDy = dy
                }
            }
            scaleDetector.onTouchEvent(motionEvent)
            if (mode == Mode.DRAG && scale >= MIN_ZOOM || mode == Mode.ZOOM) {
                parent.requestDisallowInterceptTouchEvent(true)
                val maxDx = (child().width - child().width / scale) / 2 * scale
                val maxDy = (child().height - child().height / scale) / 2 * scale
                dx = dx.coerceAtLeast(-maxDx).coerceAtMost(maxDx)
                dy = dy.coerceAtLeast(-maxDy).coerceAtMost(maxDy)
                applyScaleAndTranslation()
            }
            true
        }
    }

    override fun onScaleBegin(scaleDetector: ScaleGestureDetector): Boolean {
        return true
    }

    override fun onScale(scaleDetector: ScaleGestureDetector): Boolean {
        val scaleFactor = scaleDetector.scaleFactor
        if (lastScaleFactor == 0f || Math.signum(scaleFactor) == Math.signum(lastScaleFactor)) {
            scale *= scaleFactor
            scale = Math.max(MIN_ZOOM, Math.min(scale, MAX_ZOOM))
            lastScaleFactor = scaleFactor
            zoomCenterX = scaleDetector.focusX
            zoomCenterY = scaleDetector.focusY
        } else {
            lastScaleFactor = 0f
        }
        return true
    }

    override fun onScaleEnd(scaleDetector: ScaleGestureDetector) {}

    private fun applyScaleAndTranslation() {
        child().scaleX = scale
        child().scaleY = scale
        child().translationX = dx
        child().translationY = dy
    }

    private fun child(): View {
        return getChildAt(0)
    }

    private fun zoomTo(targetScale: Float, centerX: Float, centerY: Float) {
        zoomAnimator?.cancel()
        zoomAnimator = ValueAnimator.ofFloat(scale, targetScale).apply {
            duration = ZOOM_ANIMATION_DURATION
            addUpdateListener { animation ->
                val newScale = animation.animatedValue as Float
                val scaleRatio = newScale / scale
                dx = (dx - centerX) * scaleRatio + centerX
                dy = (dy - centerY) * scaleRatio + centerY
                scale = newScale
                applyScaleAndTranslation()
            }
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    zoomCenterX = 0f
                    zoomCenterY = 0f
                }
            })
            start()
        }
    }

    companion object {
        private const val MIN_ZOOM = 1.0f
        private const val MAX_ZOOM = 4.0f
        private const val ZOOM_ANIMATION_DURATION = 300L
    }
}
