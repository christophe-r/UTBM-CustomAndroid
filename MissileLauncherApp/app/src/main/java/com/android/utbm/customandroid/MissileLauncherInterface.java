package com.android.utbm.customandroid;

import android.util.Log;

/**
 * @brief MissileLauncherInterface is a debugging class, in the real system it will be a system class with a JNI
 */

public class MissileLauncherInterface {

    private static final String TAG = "MissileLauncherUSB";

    protected void log(String log){
        Log.d(TAG, log);
    }

    public void MlbinInitUsb(){
        log( "mlbinInitUsb: INIT");
    }

    public void MlbinFreeUsb(){
        log( "mlbinInitUsb: FREE");
    }

    public void MlbinFire(int device){
        log("mlbinInitUsb: FIRE");
    }

    public void MlbinMoveDown(int device){
        log("mlbinInitUsb: DOWN");
    }

    public void MlbinMoveLeft(int device){
        log("mlbinInitUsb: LEFT");
    }

    public void MlbinMoveRight(int device){
        log("mlbinInitUsb: RIGHT");
    }

    public void MlbinMoveUp(int device){
        log("mlbinInitUsb: UP");
    }

    public void MlbinStop(){
        log("mlbinInitUsb: STOP");
    }

    public int MlbinCountDevices(){
        log("mlbinInitUsb: COUNT");
        return 0;
    }
}
