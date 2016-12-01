package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import com.android.utbm.customandroid.MissileLauncherInterface;

import android.graphics.PointF;

/**
 * @brief MissileController is used to control the USB device, for this it generates a PWM signal from the target data
 */

public class MissileController extends Thread{

    private MissileCallback missileCallback;
    private MissileLauncherInterface mlInterface;

    private int pwmFreq = 25; // in hertz
    private boolean running = true;

    public MissileController(MissileCallback clb){
        missileCallback = clb;
        mlInterface = new MissileLauncherInterface();
        mlInterface.MlbinInitUsb();
    }

    /**
     * @brief Schedules the end of the thread
     */
    public void terminate(){
        running = false;
    }

    /**
     * @brief Launches the missile
     */
    public void fire(){
        mlInterface.MlbinFire(-1); // -1: Will fire the missile on all USB devices
    }

    /**
     * @brief Main loop of the thread
     */
    public void run() {
        try {
            while(running){
                // If the target is not used, we do not generate the PWM
                while(!missileCallback.isLauncherMoving() && running)
                    safeSleep(((long) 1000/pwmFreq));

                if(!running)
                    break;

                long halfPWMPeriod = (long) 1000/pwmFreq*2;
                PointF data = missileCallback.getTargetData();

                // Generate the PWM
                if (data.x < 0){
                    mlInterface.MlbinMoveRight(-1);
                    safeSleep(halfPWMPeriod * (long)data.x);
                    mlInterface.MlbinStop();
                    safeSleep(halfPWMPeriod * (1-(long)data.x));
                } else{ // (data.x > 0)
                    mlInterface.MlbinMoveLeft(-1);
                    safeSleep(halfPWMPeriod * (long)data.x);
                    mlInterface.MlbinStop();
                    safeSleep(halfPWMPeriod * (1-(long)data.x));
                }

                if (data.y > 0 ){
                    mlInterface.MlbinMoveUp(-1);
                    safeSleep(halfPWMPeriod * (long)data.y);
                    mlInterface.MlbinStop();
                    safeSleep(halfPWMPeriod * (1-(long)data.y));
                }else{ // (data.y < 0)
                    mlInterface.MlbinMoveDown(-1);
                    safeSleep(halfPWMPeriod * (long)data.y);
                    mlInterface.MlbinStop();
                    safeSleep(halfPWMPeriod * (1-(long)data.y));
                }
            }
        } catch (InterruptedException e) {
            this.terminate();
        }

        // Release the USB interface
        mlInterface.MlbinStop();
        mlInterface.MlbinFreeUsb();
    }


    private void safeSleep(long millis) throws InterruptedException {
        if(millis > 0)
            sleep(millis);
    }



}
