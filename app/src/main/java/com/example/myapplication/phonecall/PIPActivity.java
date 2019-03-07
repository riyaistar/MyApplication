package com.example.myapplication.phonecall;

import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Icon;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.media.session.MediaButtonReceiver;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.v4.media.session.PlaybackStateCompat.ACTION_PLAY_PAUSE;

public class PIPActivity extends AppCompatActivity {
    @BindView(R.id.videoView)
    VideoView videoView;
    @BindView(R.id.back)
    ImageButton back;
    private MediaController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pip);
        ButterKnife.bind(this);
        controller = new MediaController(this);
        videoView.setVideoURI(Uri.parse("https://www.radiantmediaplayer.com/media/bbb-360p.mp4"));
        videoView.setMediaController(controller);
        videoView.requestFocus();
        videoView.start();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onUserLeaveHint() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           // List<RemoteAction> remoteAction = new RemoteAction(android.R., "Pause","Pause", MediaButtonReceiver.buildMediaButtonPendingIntent(this, PlaybackStateCompat.ACTION_PLAY_PAUSE));
            PictureInPictureParams params =
                    new PictureInPictureParams.Builder()
                            // Set actions or aspect ratio.
                            .build();
        }

        enterPictureInPictureMode();

    }

    @Override
    public void onPictureInPictureModeChanged (
            boolean isInPictureInPictureMode, Configuration newConfig) {
        if (isInPictureInPictureMode) {
            // Hide the full-screen UI (controls, etc.) while in
            // picture-in-picture mode.
        back.setVisibility(View.GONE);
        videoView.setMediaController(null);
        } else {
            // Restore the full-screen UI.
        back.setVisibility(View.VISIBLE);
        videoView.setMediaController(controller);
        }
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @OnClick(R.id.back)
    public void backpress(){
        goback();
    }

    private void goback() {
        startActivity(new Intent(PIPActivity.this,PhoneCallActivity.class));
        finish();
    }
}
