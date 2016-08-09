package net.ddns.chrisp1985;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.chrisp.myapplication.Home_Fragment;
import com.example.chrisp.myapplication.OtherTools;
import com.example.chrisp.myapplication.ThisApplication;

import net.ddns.tests.chrisp1985.R;

import layout.ToolsFrag;

public class ChrisPNavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    Home_Fragment.OnFragmentInteractionListener,
                    ToolsFrag.OnFragmentInteractionListener,
                    ThisApplication.OnFragmentInteractionListener,
                    OtherTools.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chris_pnav_drawer);

        // Set the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fragment fragment = null;
        Class fragmentClass = Home_Fragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        // If the selection is 'Tools'...
        if (id == R.id.tools) {
            fragmentClass = ToolsFrag.class;
        }
        else if (id == R.id.home) {
            fragmentClass = Home_Fragment.class;
        }
        // If the selection is 'Other Tools'...
        else if (id == R.id.other_tools) {
            fragmentClass = OtherTools.class;
        }
        // If the selection is 'This App'...
        else if (id == R.id.this_app) {
            fragmentClass = ThisApplication.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        while(!drawer.isDrawerOpen(GravityCompat.START)) {
            // Wait
        }
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
