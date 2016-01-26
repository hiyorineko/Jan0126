package com.example.hiyoriaya.jan0126;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by SNPC2022 on 2016/01/26.
 */
public abstract class Objects {
    private Methods ms = new Methods();
    private float disp_w,disp_h;
    private Drawable img;
    private float cx,cy;
    private float vx,vy;
    private float spx,spy;
    private int imgw,imgh;
    public boolean dead;

    public Objects(){}
    public Objects(float dw,float dh){
        disp_w = dw;
        disp_h = dh;
    }
    public void Oint(Bitmap imgb,float x,float y,float sx,float sy,int w,int h){
        img = new BitmapDrawable(imgb);
        cx = ms.setSizeX(disp_w,x);
        cy = ms.setSizeY(disp_h,y);
        spx = sx;
        spy = sy;
        imgw = w;
        imgh = h;
        dead = false;
    }

    public void ODraw(Canvas c){
        if(dead == false) {
            img.setBounds((int) (cx - imgw / 2), (int) (cy - imgh / 2), (int) (cx + imgw / 2), (int) (cy + imgh / 2));
            img.draw(c);
        }
    }

    public abstract void OMove();
    public abstract OMove(int x,int y){
    }
    public abstract Rect OgetTapRect(){
    }
    public boolean OsotoX(int ww){
        return (cx-ww<0 || cx+ww>disp_w);
    }
    public boolean OsotoY(int hh){
        return (cy-hh<0 || cy+hh>disp_h);
    }

}
