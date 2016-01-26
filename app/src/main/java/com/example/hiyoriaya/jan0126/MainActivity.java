package com.example.hiyoriaya.jan0126;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
    public float disp_w,disp_h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        Window win = getWindow();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager wm = win.getWindowManager();
        Display disp = wm.getDefaultDisplay();
        disp_w = disp.getWidth();
        disp_h = disp.getHeight();
        setContentView(new MainLoop(this));
    }
}
