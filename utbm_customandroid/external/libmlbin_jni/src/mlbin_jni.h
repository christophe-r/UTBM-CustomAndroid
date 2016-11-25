#include <jni.h>

#ifndef _MLBIN_JNI_H_
#define _MLBIN_JNI_H_

JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinInitUsb(JNIEnv *env, jobject obj);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinFreeUsb(JNIEnv *env, jobject obj);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinFire(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinMoveDown(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinMoveLeft(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinMoveRight(JNIEnv *env, jobject obj, jint device);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinStop(JNIEnv *env, jobject obj);
JNIEXPORT jint JNICALL Java_com_android_utbm_customandroid_MlbinJni_MlbinCountDevices(JNIEnv *env, jobject obj);

#endif
