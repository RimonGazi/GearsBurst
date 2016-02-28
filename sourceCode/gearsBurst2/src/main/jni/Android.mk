LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

$(call import-add-path,$(LOCAL_PATH)/../../cocos2d)
$(call import-add-path,$(LOCAL_PATH)/../../cocos2d/external)
$(call import-add-path,$(LOCAL_PATH)/../../cocos2d/cocos)

LOCAL_MODULE := cocos2dcpp_shared

LOCAL_MODULE_FILENAME := libcocos2dcpp

LOCAL_SRC_FILES := hellocpp/main.cpp \
                   ../../Classes/AppDelegate.cpp \
../../Classes/Achievement.cpp \
../../Classes/AchievementsScene.cpp \
../../Classes/CreditsScene.cpp \
../../Classes/DBO.cpp \
../../Classes/GameCompleteScene.cpp \
../../Classes/GamePlayScene.cpp \
../../Classes/GearSprite.cpp \
../../Classes/GMGNativeInterface.cpp \
../../Classes/HelpScene.cpp \
../../Classes/Level.cpp \
../../Classes/LevelCompletePopup.cpp \
../../Classes/LevelFailedPopup.cpp \
../../Classes/LevelSelectionScene.cpp \
../../Classes/LogosScene.cpp \
../../Classes/MainMenuScene.cpp \
../../Classes/OptionsScene.cpp \
../../Classes/PauseMenuPopup.cpp \
../../Classes/SplashScene.cpp \
../../Classes/StoreItem.cpp \
../../Classes/StoreScene.cpp \
../../Classes/SonarFrameworks.cpp \
../../Classes/JNIHelpers.cpp \
../../Classes/JNIResults.cpp \
../../Classes/sqlite/sqlite3.c

LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../Classes \
                    $(LOCAL_PATH)/../../Classes/sqlite

LOCAL_STATIC_LIBRARIES := cocos2dx_static

LOCAL_WHOLE_STATIC_LIBRARIES += PluginIAP
LOCAL_WHOLE_STATIC_LIBRARIES += PluginFacebook
LOCAL_WHOLE_STATIC_LIBRARIES += sdkbox


include $(BUILD_SHARED_LIBRARY)

$(call import-add-path,$(LOCAL_PATH))
$(call import-module,.)
$(call import-module, ./sdkbox)
$(call import-module, ./pluginiap)
$(call import-module, ./pluginfacebook)
