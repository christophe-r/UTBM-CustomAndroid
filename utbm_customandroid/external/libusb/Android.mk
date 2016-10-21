#########################################################################
# libusb
#########################################################################

# Build

LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

# Optional tag would mean it doesn't get installed by default
LOCAL_MODULE_TAGS := optional

#LOCAL_CFLAGS := -Werror

LOCAL_SRC_FILES:= src/os/linux_usbfs.c \
		  src/os/threads_posix.c \
		  src/core.c \
		  src/descriptor.c \
		  src/io.c \
		  src/sync.c

LOCAL_C_INCLUDES:= device/utbm/utbm_customandroid/external/libusb/src/

LOCAL_MODULE := libusb

include $(BUILD_SHARED_LIBRARY)
