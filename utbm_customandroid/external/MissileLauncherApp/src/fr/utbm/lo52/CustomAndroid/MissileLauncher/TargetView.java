package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.content.Context;
import android.util.AttributeSet;
//import android.support.v4.content.ContextCompat;
//import android.support.annotation.NonNull;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;


/**
 * @brief TargetView is a custom view that draw and animate the target
 */

public class TargetView extends View {

    // The size of the user point
    private int targetPointSize = 30;

    private PointF centerPoint;
    private PointF userPoint;
    private Paint targetPaint = new Paint();
    private Paint linePaint = new Paint();
    private Paint userPaint = new Paint();
    private float min_size;
    private boolean targetMoving = false;

    public TargetView(Context context) {
        super(context);
        this.initInterface();
    }

    public TargetView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initInterface();
    }

    public TargetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initInterface();
    }

    /**
     * @brief Initializes all the Paint and Point objects
     */
    protected void initInterface(){
        userPoint = new PointF(this.getWidth()/2, (float)(this.getHeight()/2));
        centerPoint = new PointF(this.getWidth()/2, (float)(this.getHeight()/2));

        targetPaint.setStyle(Paint.Style.STROKE);
        targetPaint.setStrokeWidth(2);
        //targetPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorDivider));
        //linePaint.setColor(ContextCompat.getColor(getContext(), R.color.colorDivider));
        //userPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));


    }

    /**
     * @brief Returns the user point coordinates (in percentage) compared to the center of the target
     * @return (PointF) The coordinates point
     */
    public PointF getUserPoint(){
        return new PointF((centerPoint.x - userPoint.x )/ min_size, (centerPoint.y - userPoint.y)/min_size) ;
    }

    /**
     * @brief Returns true if the user is currently moving the target
     * @return (boolean) The value
     */
    public boolean isTargetMoving(){
        return targetMoving;
    }

    /**
     * @brief Starts a animation to return the user point at the center
     */
    protected void startReturnAnim(){
        ObjectAnimator animX = ObjectAnimator.ofFloat(this, "userPointX", userPoint.x, centerPoint.x);
        ObjectAnimator animY = ObjectAnimator.ofFloat(this, "userPointY", userPoint.y, centerPoint.y);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.setInterpolator(new DecelerateInterpolator());
        animSetXY.playTogether(animX, animY);
        animSetXY.start();
    }

    /**
     * @brief This getter is called by the ObjectAnimator class
     * @param newX (float) The new value for the x coordinate of the user point
     */
    public void setUserPointX(float newX){
        userPoint.x = newX;
        invalidate();
    }

    /**
     * @brief This getter is called by the ObjectAnimator class
     * @param newY (float) The new value for the y coordinate of the user point
     */
    public void setUserPointY(float newY){
        userPoint.y = newY;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(/*@NonNull*/ MotionEvent event) {
        userPoint.set(event.getX(), event.getY());
        if(event.getActionMasked() == ACTION_UP){
            targetMoving = false;
            startReturnAnim();
        }
        if(event.getActionMasked() == ACTION_DOWN)
            targetMoving = true;

        invalidate();
        return true;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        userPoint = new PointF(w/2, (float)(h/2));
        centerPoint = new PointF(w/2, (float)(h/2));

        double scalingFactor = 2.5;
        min_size = (float) (w/ scalingFactor);
        if(min_size > (float)(h/ scalingFactor))
            min_size =(float)(h/ scalingFactor);
    }

    /**
     * @brief Draws the elements on the screen
     * @param canvas (Canvas) The canvas object we can use to draw
     */
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draws the target circle, lines, and the point
        canvas.drawCircle (centerPoint.x, centerPoint.y, min_size, targetPaint);
        canvas.drawLine(centerPoint.x - min_size, centerPoint.y, centerPoint.x + min_size, centerPoint.y, linePaint);
        canvas.drawLine(centerPoint.x , centerPoint.y - min_size, centerPoint.x , centerPoint.y + min_size, linePaint);
        canvas.drawCircle(centerPoint.x, centerPoint.y, 5, linePaint);

        // Checks if the user point is inside the target
        double dist = Math.sqrt(Math.pow(centerPoint.x - userPoint.x, 2)+ Math.pow(centerPoint.y - userPoint.y, 2) );
        if(dist <= min_size) {
            canvas.drawCircle(userPoint.x, userPoint.y, targetPointSize, userPaint);
        }else{
            // If the user point is not inside the target, we calculate its coordinates at the border of the circle
            double t = 3*Math.PI/2 - Math.atan2((centerPoint.x - userPoint.x),(centerPoint.y - userPoint.y));
            userPoint.x = (float)(centerPoint.x + min_size*Math.cos(t));
            userPoint.y =(float)(centerPoint.y + min_size*Math.sin(t));
            canvas.drawCircle(userPoint.x, userPoint.y, targetPointSize, userPaint);
        }
    }
}
