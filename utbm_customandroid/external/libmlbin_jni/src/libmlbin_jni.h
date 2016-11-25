#include <jni.h>

#ifndef _LIBMLBIN_JNI_H_
#define _LIBMLBIN_JNI_H_

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinInitUsb(JNIEnv *env, jobject obj);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinFreeUsb(JNIEnv *env, jobject obj);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinFire(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveDown(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveLeft(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinMoveRight(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinStop(JNIEnv *env, jobject obj);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MissileLauncherInterface_MlbinCountDevices(JNIEnv *env, jobject obj);

#endif
