package com.example.kioskmainpage.Activity.Senior_MenuOption;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.example.kioskmainpage.R;

import java.io.IOException;

public class Senior_Video_Activity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer = null;
    private SurfaceView mSurfaceView;
    private TextView title;
    private SurfaceHolder mSurfaceHolder;
    private String mSdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String mVideoFile = “menu.mp4”;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView)findViewById(R.id.title_view);
        Spannable span = (Spannable) title.getText();
        span.setSpan(new ForegroundColorSpan(getColor(R.color.red)), 27, 34, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

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

    public void stopVideo(View view) {
    }

    public void startVideo(View view) {
        try {
            mMediaPlayer.setDataSource(mSdPath + "/" + mVideoFile);
            mMediaPlayer.setDisplay(mSurfaceHolder);
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }

}


