#########################################################################
# mlbin
#########################################################################

# Build

LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

# Optional tag would mean it doesn't get installed by default
LOCAL_MODULE_TAGS := optional

#LOCAL_CFLAGS := -Werror

LOCAL_SRC_FILES:= src/mlbin.c

LOCAL_C_INCLUDES:= device/utbm/utbm_customandroid/external/mlbin/src/ \
		   device/utbm/utbm_customandroid/external/libusb/src/

LOCAL_SHARED_LIBRARIES := libusb

LOCAL_MODULE := mlbin

include $(BUILD_EXECUTABLE)
