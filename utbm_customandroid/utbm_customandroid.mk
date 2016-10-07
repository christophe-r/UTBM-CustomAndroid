$(call inherit-product, device/linaro/arrow/arrow.mk)


#PRODUCT_PACKAGES +=
	
DEVICE_PACKAGE_OVERLAYS := device/utbm/utbm_customandroid/overlay

PRODUCT_COPY_FILES += device/utbm/utbm_customandroid/copy/bootanimation.zip:system/media/bootanimation.zip


#PRODUCT_PROPERTY_OVERRIDES +=


PRODUCT_NAME:= utbm_customandroid
PRODUCT_DEVICE:= utbm_customandroid
PRODUCT_BRAND:= UTBM-CustomAndroid
PRODUCT_MODEL:= UTBM-CustomAndroid-A2016

include $(call all-subdir makefiles)

