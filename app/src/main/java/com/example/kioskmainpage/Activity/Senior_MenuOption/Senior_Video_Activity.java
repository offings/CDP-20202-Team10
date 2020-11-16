package com.example.kioskmainpage.Activity.Senior_MenuOption;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kioskmainpage.Activity.Pay.Senior_Pay_Loading;
import com.example.kioskmainpage.Activity.Waiting.Senior_MainActivity;
import com.example.kioskmainpage.R;

import java.io.IOException;

public class Senior_Video_Activity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer = null;
    private SurfaceView mSurfaceView;
    private TextView title;
    private SurfaceHolder mSurfaceHolder;
    private boolean video_prepared = false;
    private String mSdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String[] mVideoFileList = {"coffee.mp4", "drink.mp4", "orderlist.mp4", "payment.mp4"};
    private String mVideoFile = "coffee.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_video);

        int uiOptions = getWindow().getDecorView().getSystemUiVisibility();
        int newUiOptions = uiOptions;
        newUiOptions ^= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        newUiOptions ^= View.SYSTEM_UI_FLAG_FULLSCREEN;
        newUiOptions ^= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        getWindow().getDecorView().setSystemUiVisibility(newUiOptions);
        this.setFinishOnTouchOutside(false);

        title = (TextView)findViewById(R.id.title_view);
        Spannable span = (Spannable) title.getText();
        span.setSpan(new ForegroundColorSpan(getColor(R.color.red)), 4, 9, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.video_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("커피 주문"));
        tabLayout.addTab(tabLayout.newTab().setText("기타 주문"));
        tabLayout.addTab(tabLayout.newTab().setText("장바구니"));
        tabLayout.addTab(tabLayout.newTab().setText("결제 과정"));
        tabLayout.getTabAt(0).select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVideoFile = mVideoFileList[tab.getPosition()];
                video_prepared = false;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                stopVideo(mSurfaceView);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mSurfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        mSurfaceHolder = mSurfaceView.getHolder();
        //mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mMediaPlayer = new MediaPlayer();
    }

    @Override
    protected void onDestroy() {
        if(mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
        super.onDestroy();
    }

    public void startVideo(View view) {
        if(!video_prepared) {
            try {
                mMediaPlayer.setDataSource(mSdPath + "/" + mVideoFile);
                mMediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            video_prepared = true;
        }
        mMediaPlayer.setLooping(false);
        mMediaPlayer.start();
    }

    public void stopVideo(View view) {
        mMediaPlayer.stop();
        mMediaPlayer.reset();
    }


    public void onClick_back(View view) {
        finish();
    }
}


