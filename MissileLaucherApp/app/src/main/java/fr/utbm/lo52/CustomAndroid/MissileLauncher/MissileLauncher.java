package fr.utbm.lo52.CustomAndroid.MissileLauncher;

import com.android.utbm.customandroid.MissileLauncherInterface;


public class MissileLauncher {


    private MissileLauncherInterface mlInterface;

    public MissileLauncher(){
        mlInterface = new MissileLauncherInterface();
    }


    public void Init(){
       mlInterface.MlbinInitUsb();
    }

    public void FreeUsb(){
       mlInterface.MlbinFreeUsb();
    }

    public void Fire(int device){
        mlInterface.MlbinFire(device);
    }

    public void MoveDown(int device){
       mlInterface.MlbinMoveDown(device);
    }

    public void MoveLeft(int device){
       mlInterface.MlbinMoveLeft(device);
    }

    public void MoveRight(int device){
        mlInterface.MlbinMoveRight(device);

    }

    public void MoveUp(int device){
       mlInterface.MlbinMoveUp(device);
    }

    public void Stop(){
       mlInterface.MlbinStop();
    }

    public int CountDevices(){
        return mlInterface.MlbinCountDevices();
    }
}
