package com.example.hiyoriaya.jan0126;

import android.graphics.Rect;

/**
 * Created by SNPC2022 on 2016/01/26.
 */
public class Jiki extends Objects{
    public Jiki(){}
    public Jiki(float dw,float dh){
        super(dw,dh);
    }

    public abstract OMove(int x,int y){
        float cxx = cx;
        float cyy = cy;
        cx = x;
        cy = y;
        if(cx-imgw/2<0 || cx+imgw/2>disp_w) cx = cxx;
        if(cy-imgh/2<0 || cy+imgh/2>disp_h) cy = cyy;
    }

    public Rect OgetTapRect(){
        Rect taprect = new Rect(
                img.getBounds().left-50,img.getBounds().top-50,
                img.getBounds().right+50,img.getBounds().bottom+50);
        return taprect;
    }
}
