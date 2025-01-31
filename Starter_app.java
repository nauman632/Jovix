package com.example.madprojectassign3;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Starter_app extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter_app);


        ImageView spinner1 = findViewById(R.id.circularSpinner1);
        ImageView spinner2 = findViewById(R.id.circularSpinner2);
        ImageView spinner3 = findViewById(R.id.circularSpinner3);
        ImageView spinner4 = findViewById(R.id.circularSpinner4);


        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);


        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(0);


        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                playAudio();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent = new Intent(Starter_app.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        spinner1.startAnimation(rotateAnimation);
        spinner2.startAnimation(rotateAnimation);
        spinner3.startAnimation(rotateAnimation);
        spinner4.startAnimation(rotateAnimation);

        mediaPlayer = MediaPlayer.create(this, R.raw.jovix);
    }

    private void playAudio() {
        try {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mp -> {
                    mp.release();
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
