package net.ddns.chrisp1985;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import net.ddns.tests.chrisp1985.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.setClass(this, ChrisPNavDrawer.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
    }
}
