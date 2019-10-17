package com.gail.wenzhi.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;

public class ColorUtils {
    public static int GlobalColor = 0xff1587E9;
    public static int WhiteColor = 0xffffffff;
    public static int GlobalColorSelected = 0xffffffff;
    public static String GlobalColorString = "#FFD43B33";

    public static int GlobalTextColorTitle = 0xff606060;
    public static int GlobalTextColorSubtitle = 0xff7f7d7d;

    public static ColorStateList colorStateList= null;

    public static ColorStateList getColorStateList(int mode)
    {
        if(colorStateList == null)
        {
            int[][] states = new int[2][];
            states[0] = new int[]{android.R.attr.state_pressed};
            states[1] = new int[]{android.R.attr.state_enabled};

            int[] colors = new int[]{GlobalColor, GlobalColor};

            colorStateList = new ColorStateList(states, colors);
        }
        return colorStateList;
    }

    public static void SetThemeColor(int BackColor, boolean backColorLight)
    {
        GlobalColor = BackColor;
        if(backColorLight == true)
        {
            GlobalTextColorTitle = 0xff606060;
            GlobalTextColorSubtitle = 0xff7f7d7d;
        }
        else
        {
            GlobalTextColorTitle = 0xffffffff;
            GlobalTextColorSubtitle = 0xffd0cece;
        }
    }



    public  static String toHexEncoding(int color) {
        String R, G, B;
        StringBuffer sb=new StringBuffer();
        R= Integer.toHexString(Color.red(color));
        G= Integer.toHexString(Color.green(color));
        B= Integer.toHexString(Color.blue(color));
        R=R.length()==1?"0"+R:R;
        G=G.length()==1?"0"+G:G;
        B=B.length()==1?"0"+B:B;
        sb.append("#");
        sb.append(R.toUpperCase());
        sb.append(G.toUpperCase());
        sb.append(B.toUpperCase());
        return sb.toString();
    }
}
