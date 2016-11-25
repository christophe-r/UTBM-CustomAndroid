#########################################################################
# mlbin
#########################################################################

# Build

LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

# Optional tag would mean it doesn't get installed by default
LOCAL_MODULE_TAGS := optional

#LOCAL_CFLAGS := -Werror

LOCAL_SRC_FILES:= src/libmlbin_jni.c

LOCAL_C_INCLUDES:= device/utbm/utbm_customandroid/external/libmlbin_jni/src/ \
		   device/utbm/utbm_customandroid/external/mlbin/src/ \

LOCAL_SHARED_LIBRARIES := libmlbin

LOCAL_MODULE := libmlbin_jni

include $(BUILD_SHARED_LIBRARY)
