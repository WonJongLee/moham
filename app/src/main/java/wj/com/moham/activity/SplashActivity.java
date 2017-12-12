package wj.com.moham.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wj.com.moham.R;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable()  {
            public void run() {
                goMainAct();
            }
        }, SPLASH_TIME);
    }

    private void goMainAct() {
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}
