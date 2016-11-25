#########################################################################
# MissileLauncherInterface JAVA
#########################################################################

# Build

LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

# Optional tag would mean it doesn't get installed by default
LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES:= $(call all-java-files-under, src)

LOCAL_MODULE := com.android.utbm.customandroid.MissileLauncherInterface

include $(BUILD_JAVA_LIBRARY)


#########################################################################
# MissileLauncherInterface XML
#########################################################################


include $(CLEAR_VARS)

LOCAL_MODULE := com.android.utbm.customandroid.MissileLauncherInterface.xml

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES:= $(LOCAL_MODULE)

LOCAL_MODULE_CLASS := ETC

LOCAL_MODULE_PATH := $(TARGET_OUT_ETC)/permissions

include $(BUILD_PREBUILD)





