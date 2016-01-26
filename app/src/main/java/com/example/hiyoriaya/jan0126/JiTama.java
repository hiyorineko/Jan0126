package com.example.hiyoriaya.jan0126;

import android.graphics.Rect;

/**
 * Created by SNPC2022 on 2016/01/26.
 */
public class JiTama extends Objects {
    public JiTama();
    public JiTama(float dw,float dh){
        super(dw,dh);
    }

    public void OMove(){
        cy -= spy;
        if(OsotoY(-imgh/2)==true)dead = true;
    }

    public void OMove(int x,int y){}
    public Rect OgetTapRect(){return null};
}
