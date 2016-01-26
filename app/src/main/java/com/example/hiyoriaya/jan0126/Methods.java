package com.example.hiyoriaya.jan0126;

import android.graphics.Rect;

/**
 * Created by SNPC2022 on 2016/01/26.
 */
public class Methods {

    static public final float MYH = 1920;
    static public final float MYW = 1080;
    static public final float ZERO = 0f;

    public boolean RectTap(int x,int y,Rect gazou){
        return gazou.left < x && gazou.top < y && gazou.right > x && gazou.bottom > y;
    }

    public int setSizeX(float disp_w,float zahyou){
        return (int)(zahyou *(disp_w/MYW));
    }

    public int setSizeY(float disp_h,float zahyou){
        return (int)(zahyou *(disp_h / MYH));
    }
}
