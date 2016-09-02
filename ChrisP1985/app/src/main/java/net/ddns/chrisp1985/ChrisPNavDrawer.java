package net.ddns.chrisp1985;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.sdsmdg.tastytoast.TastyToast;

import net.ddns.tests.chrisp1985.R;

public class ChrisPNavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    Home_Fragment.OnFragmentInteractionListener,
                    ToolsFrag.OnFragmentInteractionListener,
                    ToolsFrag2.OnFragmentInteractionListener,
                    ThisApplication.OnFragmentInteractionListener,
                    OtherTools.OnFragmentInteractionListener,
                    OtherToolsFrag2.OnFragmentInteractionListener {

    /**
     * Create the Nav Drawer view.
     * @param savedInstanceState The current instance state.
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Fix the orientation (portrait screws up on tablets).
        if(getResources().getBoolean(R.bool.landscape_only)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        // Create the initial view for the application.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chris_pnav_drawer);

        // Set the toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the alpha (opaqueness) of the image on the toolbar.
        ImageView toolbarImage = (ImageView) toolbar.findViewById(R.id.toolbarImage);
        toolbarImage.setImageAlpha(80);

        // Set the initial fragment to be the home fragment.
        Fragment fragment = null;
        Class fragmentClass = Home_Fragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Replace whatever it's already got with the home fragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Set the drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // Set the navigation view.
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    /**
     * What to do when Back is pressed on the drawer.
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * What to do when the navigation item is selected in the drawer.
     * @param item The item selected.
     * @return Boolean to say the action has been done.
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Get the selected item
        int id = item.getItemId();

        // Set the initial fragment/class to null.
        Fragment fragment = null;
        Class fragmentClass = null;

        // If the selection is 'Tools'...
        if (id == R.id.tools) {
            // Set the fragment.
            fragmentClass = ToolsFrag.class;

            // Produce a toaster to make the user aware of the WebView button.
            TastyToast.makeText(getApplicationContext(), "Use WebView to see examples.", TastyToast.LENGTH_LONG, TastyToast.INFO);
        }
        else if (id == R.id.home) {
            // Set the fragment.
            fragmentClass = Home_Fragment.class;
        }
        // If the selection is 'Other Tools'...
        else if (id == R.id.other_tools) {
            // Set the fragment.
            fragmentClass = OtherTools.class;

            // Produce a toaster to make the user aware of the WebView button.
            TastyToast.makeText(getApplicationContext(), "Use WebView to see examples.", TastyToast.LENGTH_LONG, TastyToast.INFO);
        }
        // If the selection is 'This App'...
        else if (id == R.id.this_app) {
            // Set the fragment.
            fragmentClass = ThisApplication.class;
        }
        else if (id == R.id.open_website) {
            // Set and launch the browser.
            Uri uriUrl = Uri.parse("http://chrisp1985.github.io/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);

            // Produce a toaster to say goodbye.
            TastyToast.makeText(getApplicationContext(), "Have Fun", TastyToast.LENGTH_LONG, TastyToast.SUCCESS);

            // Set the home fragment.
            fragmentClass = Home_Fragment.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Close the drawer.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        // Replace the current fragment with the new one.
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        return true;
    }

    /**
     *
     * @param uri
     */
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * What happens when the monkey is clicked in the taskbar (hint, you go to home).
     * @param view The view to pass in via the onClick method of the image.
     */
    public void onMonkeyClick(View view) {
        Fragment fragment = null;
        Class fragmentClass = Home_Fragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    /**
     * What happens when the tools webview is clicked.
     * @param view The view to pass in via the onClick method of the image.
     */
    public void onToolsWebViewClick(View view) {
        Fragment fragment = null;
        Class fragmentClass = ToolsFrag2.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }

    /**
     * What happens when the other tools webview is clicked.
     * @param view The view to pass in via the onClick method of the image.
     */
    public void onOtherToolsWebViewClick(View view) {
        Fragment fragment = null;
        Class fragmentClass = OtherToolsFrag2.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
    }
}
