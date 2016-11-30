package com.android.utbm.customandroid;

import android.util.Log;

/**
 * Created by lo52tp on 25/11/16.
 */

public class MissileLauncherInterface {

    private static final String TAG = "MissileLauncherUSB";

    public void MlbinInitUsb(){
        Log.i(TAG, "mlbinInitUsb: INIT");
    }

    public void MlbinFreeUsb(){
        Log.i(TAG, "mlbinInitUsb: FREE");
    }

    public void MlbinFire(int device){
        Log.i(TAG, "mlbinInitUsb: FIRE");
    }

    public void MlbinMoveDown(int device){
        Log.i(TAG, "mlbinInitUsb: DOWN");
    }

    public void MlbinMoveLeft(int device){
        Log.i(TAG, "mlbinInitUsb: LEFT");
    }

    public void MlbinMoveRight(int device){
        Log.i(TAG, "mlbinInitUsb: RIGHT");
    }

    public void MlbinMoveUp(int device){
        Log.i(TAG, "mlbinInitUsb: UP");
    }

    public void MlbinStop(){
        Log.i(TAG, "mlbinInitUsb: STOP");
    }

    public int MlbinCountDevices(){
        Log.i(TAG, "mlbinInitUsb: COUNT");
        return 0;
    }
}
