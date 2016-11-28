package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;

/**
 * Created by lo52tp on 25/11/16.
 */

public class TargetView extends View {


    private PointF centerpoint;
    private PointF userPoint;
    private Paint targetPaint = new Paint();
    private Paint userPaint = new Paint();
    private float min_size;

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

    protected void initInterface(){
        Log.i(TAG, "x: " + this.getWidth());
        Log.i(TAG, "y: " + (float)(this.getHeight()));
        userPoint = new PointF(this.getWidth()/2, (float)(this.getHeight()/2));
        centerpoint = new PointF(this.getWidth()/2, (float)(this.getHeight()/2));

        targetPaint.setStyle(Paint.Style.STROKE);
        targetPaint.setStrokeWidth(2);
        targetPaint.setColor(Color.BLACK);
    }

    public PointF getUserPoint(){
        return new PointF(centerpoint.x - userPoint.x, centerpoint.y - userPoint.y) ;
    }

    public double getDistance(){
        return Math.sqrt(Math.pow(centerpoint.x - userPoint.x, 2)+ Math.pow(centerpoint.y - userPoint.y, 2) )/ min_size;
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TargetView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        userPoint.set(event.getX(), event.getY());
        invalidate();
        return true;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        userPoint = new PointF(w/2, (float)(h/2));
        centerpoint = new PointF(w/2, (float)(h/2));

        min_size = w/3;
        if(min_size > h/3)
            min_size = h/3;

        Log.i(TAG, "onSizeChanged: " + min_size);
    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        // Draw the pointer
        //canvas.drawLine(0, 0, 10, 10, new Paint());

       // canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, min_size/10, new Paint());

        double dist = Math.sqrt(Math.pow(centerpoint.x - userPoint.x, 2)+ Math.pow(centerpoint.y - userPoint.y, 2) );
        if(dist <= min_size) {
            canvas.drawCircle(userPoint.x, userPoint.y, 20, userPaint);
        }
        else{
            double t = 3*Math.PI/2 - Math.atan2((centerpoint.x - userPoint.x),(centerpoint.y - userPoint.y));
           // Log.i(TAG, "onDraw: " + user);
            userPoint.x = (float)(centerpoint.x + min_size*Math.cos(t));
            userPoint.y =(float)(centerpoint.y + min_size*Math.sin(t));
            canvas.drawCircle(userPoint.x, userPoint.y, 20, userPaint);
        }
        canvas.drawCircle(centerpoint.x, centerpoint.y, 10, userPaint);
        canvas.drawCircle (centerpoint.x, centerpoint.y, min_size, targetPaint);

    }
}
