#include <stdio.h>
#include <stdlib.h>

#include <mlbin.h>

#include "libmlbin_jni.h"

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinInitUsb(JNIEnv *env, jobject obj)
{
	return mlbin_init_usb();
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinFreeUsb(JNIEnv *env, jobject obj)
{
	return mlbin_free_usb();
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinFire(JNIEnv *env, jobject obj, jint device)
{
	return mlbin_fire(device);
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveUp(JNIEnv *env, jobject obj, jint device)
{
	return mlbin_move_up(device);
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveDown(JNIEnv *env, jobject obj, jint device)
{
	return mlbin_move_down(device);
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveLeft(JNIEnv *env, jobject obj, jint device)
{
	return mlbin_move_left(device);
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveRight(JNIEnv *env, jobject obj, jint device)
{
	return mlbin_move_right(device);
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinStop(JNIEnv *env, jobject obj)
{
	return mlbin_stop();
}

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinCountDevices(JNIEnv *env, jobject obj)
{
	return mlbin_count_devices();
}

