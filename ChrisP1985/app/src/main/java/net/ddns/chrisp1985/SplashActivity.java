package net.ddns.chrisp1985;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;

import net.ddns.tests.chrisp1985.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            public void run() {

                Intent intent = new Intent();
                intent.setClass(SplashActivity.this, ChrisPNavDrawer.class);

                startActivity(intent);
                finish();

                // transition from splash to main menu
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

            }
        }, 0);
//        Intent intent = new Intent();
//        intent.setClass(this, ChrisPNavDrawer.class);
//        startActivity(intent);
//        overridePendingTransition(0, R.anim.fade_out);
    }
}
