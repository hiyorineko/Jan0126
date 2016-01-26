package com.example.hiyoriaya.jan0126;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by SNPC2022 on 2016/01/26.
 */
public class MainLoop extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    private SurfaceHolder holder;
    private Thread thread;

    private Methods ms;
    private MainActivity ma;
    private float disp_w,disp_h;
    private Drawable jikiimg,tamaimg;

    private Objects jiki;

    public MainLoop(Context context){
        super(context);
        init(context);
    }

    public MainLoop(Context context,AttributeSet attrs){
        super(context,attrs);
        init(context);
    }

    public void init(Context context){
        holder = getHolder();
        holder.addCallback(this);
        holder.setFixedSize(getWidth(), getHeight());
        ma = (MainActivity)context;
        ms = new Methods();
        disp_w = ma.disp_w;
        disp_h = ma.disp_h;

        Resources resources = context.getResources();
        Bitmap img = BitmapFactory.decodeResource(resources, R.drawable.jiki);
        Bitmap jikibit = Bitmap.createBitmap(img, 0, 0, img.getWidth() / 3, img.getHeight());
        Bitmap tamabit = Bitmap.createBitmap(img,img.getWidth()/2,0,img.getWidth()/2,img.getHeight());

        jiki = new Jiki(disp_w,disp_h);
        jiki.Oint(jikibit,240,800,10,10,jikibit.getWidth(),jikibit.getHeight());
    }

    public void run(){
        Canvas c;
        Paint p = new Paint();
        p.setAntiAlias(true);

        while(thread != null){
            c = holder.lockCanvas();
            c.drawColor(Color.BLACK);
            jiki.ODraw(c);

            holder.unlockCanvasAndPost(c);

            try{
                Thread.sleep(50);
            }catch(InterruptedException e){}
        }
    }

    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                if(ms.RectTap(x,y,jiki.OgetTapRect())==true)jiki.OMove(x,y);
                break;
        }
        return true;
    }

    public void surfaceChanged(SurfaceHolder arg0,int arg1,int arg2,int arg3){
    }

    public void surfaceCreated(SurfaceHolder arg0){
        thread = new Thread(this);
        thread.start();
    }

    public void surfaceDestroyed(SurfaceHolder arg0){
        thread = null;
    }
}
