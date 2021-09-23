package com.apptrends.apptrends;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.apptrendstickerview.stickerview.AutofitTextRel;
import com.apptrendstickerview.stickerview.ImageUtils;
import com.apptrendstickerview.stickerview.ResizableStickerView;
import com.apptrendstickerview.stickerview.ApptendsStickerInfo;

public class MainActivity extends AppCompatActivity implements ResizableStickerView.OnTouchListener, AutofitTextRel.TouchEventListener {
    RelativeLayout txt_stkr_rel;
    String[] fonts = {
            "fontmain.ttf",
            "font2.ttf",
            "font4.ttf",
            "font3.ttf"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        txt_stkr_rel = findViewById( R.id.txt_stkr_rel );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int display_width = displayMetrics.widthPixels;
                int display_height = displayMetrics.heightPixels;
                ApptendsStickerInfo apptendsStickerInfo = new ApptendsStickerInfo();
                apptendsStickerInfo.setPOS_X( (float) ((display_width / 1.8) - ImageUtils.dpToPx( MainActivity.this, 100 )) );
                apptendsStickerInfo.setPOS_Y( (float) ((display_height / 2.2) - ImageUtils.dpToPx( MainActivity.this, 100 )) );
                apptendsStickerInfo.setWIDTH( ImageUtils.dpToPx( MainActivity.this, 150 ) );
                apptendsStickerInfo.setHEIGHT( ImageUtils.dpToPx( MainActivity.this, 85 ) );
                apptendsStickerInfo.setTEXT( "Hello Apptrends" );
                apptendsStickerInfo.setFONT_NAME( fonts[2] );
                apptendsStickerInfo.setTEXT_COLOR( Color.parseColor( "#ffffff" ) );
                apptendsStickerInfo.setTEXT_ALPHA( 255 );
                apptendsStickerInfo.setSHADOW_COLOR( Color.BLACK );
                apptendsStickerInfo.setSHADOW_PROG( 0 );
                apptendsStickerInfo.setSHADOW_X( 0 );
                apptendsStickerInfo.setSHADOW_Y( 0 );
                apptendsStickerInfo.setBG_COLOR( Color.TRANSPARENT );
                apptendsStickerInfo.setBG_DRAWABLE( "0" );
                apptendsStickerInfo.setBG_ALPHA( 0 );
                apptendsStickerInfo.setROTATION( 0.0f );
                apptendsStickerInfo.setFIELD_TWO( "" );
                AutofitTextRel autofitTextRel = new AutofitTextRel( MainActivity.this );
                txt_stkr_rel.addView( autofitTextRel );
                autofitTextRel.setTextInfo( apptendsStickerInfo, false );
                autofitTextRel.setDefaultTouchListener( true );
                autofitTextRel.setOnTouchCallbackListener( MainActivity.this );
                autofitTextRel.setBorderVisibility( true );
                txt_stkr_rel.invalidate();
            }
        }, 500 );

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onDelete(View view) {

    }

    @Override
    public void onDoubleTap() {

    }

    @Override
    public void onEdit(View view) {

    }

    @Override
    public void onRotateDown(View view) {

    }

    @Override
    public void onRotateMove(View view) {

    }

    @Override
    public void onRotateUp(View view) {

    }

    @Override
    public void onScaleDown(View view) {

    }

    @Override
    public void onScaleMove(View view) {

    }

    @Override
    public void onScaleUp(View view) {

    }

    @Override
    public void onTouchDown(View view) {

    }

    @Override
    public void onTouchMove(View view) {

    }

    @Override
    public void onTouchUp(View view) {

    }
}