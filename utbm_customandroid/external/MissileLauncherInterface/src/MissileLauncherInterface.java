package com.android.utbm.customandroid.MissileLauncherInterface;

public class MissileLauncherInterface {

	static {
		System.loadLibrary("mlbin_jni");
	}

	public native int MlbinInitUsb();
	public native int MlbinFreeUsb();
	public native int MlbinFire(int device);
	public native int MlbinMoveDown(int device);
	public native int MlbinMoveLeft(int device);
	public native int MlbinMoveRight(int device);
	public native int MlbinStop();
	public native int MlbinCountDevices();

}
