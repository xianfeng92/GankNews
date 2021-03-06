package com.example.zhongxianfeng.ganknews.app.utils;


public class CategoryType {

    public static final String ANDROID_STR = "Android";
    public static final String QIAN_STR = "前端";
    public static final String EXPAND_STR = "拓展资源";
    public static final String GIRLS_STR = "福利";


    public static final int ANDROID_IOS = 1;
    public static final int GIRLS = 2;

    public static String getPageTitleByPosition(int position) {
        if (position == 0){
            return ANDROID_STR;
        } else if (position == 1){
            return QIAN_STR;
        } else if (position == 2){
            return EXPAND_STR;
        } else {
            return "";
        }
    }
}
