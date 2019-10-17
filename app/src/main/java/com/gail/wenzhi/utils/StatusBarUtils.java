package com.gail.wenzhi.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class StatusBarUtils {
    public static void setWindowStatusBarColor(Activity activity, String color) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = activity.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor(color));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setWindowStatusBarColor(Dialog dialog, String color) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = dialog.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor(color));

                //底部导航栏
                //window.setNavigationBarColor(activity.getResources().getColor(colorResId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RippleView(View view, Context context)
    {
        if(Build.VERSION.SDK_INT >= 21)
        {
            int[] attrsArray = { android.R.attr.selectableItemBackgroundBorderless };
            TypedArray typedArray = context.obtainStyledAttributes(attrsArray);
            int selector = typedArray.getResourceId(0, attrsArray[0]);
            view.setBackgroundResource(selector);
            typedArray.recycle();
        }
        else
        {
            int[] attrsArray = { android.R.attr.selectableItemBackground };
            TypedArray typedArray = context.obtainStyledAttributes(attrsArray);
            int selector = typedArray.getResourceId(0, attrsArray[0]);
            view.setBackgroundResource(selector);
            typedArray.recycle();
        }

    }





}