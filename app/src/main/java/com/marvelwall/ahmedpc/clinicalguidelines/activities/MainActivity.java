package com.marvelwall.ahmedpc.clinicalguidelines.activities;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.marvelwall.ahmedpc.clinicalguidelines.fragments.AboutUsFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.FeverFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.HomeFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.LoginFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.MainFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.MangmentFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.R;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.ReportCaseFragment;
import com.marvelwall.ahmedpc.clinicalguidelines.fragments.ViewPdfFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MainFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener,
        HomeFragment.OnFragmentInteractionListener,
        FeverFragment.OnFragmentInteractionListener,
        MangmentFragment.OnFragmentInteractionListener,
        AboutUsFragment.OnFragmentInteractionListener,
        ViewPdfFragment.OnFragmentInteractionListener,
        ReportCaseFragment.OnFragmentInteractionListener {
    DrawerLayout drawer;
    ImageView openDrawer;
    NavigationView navigationView;
    private FragmentManager manager;
    private FragmentTransaction transaction;
   public static  String currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        openDrawer = findViewById(R.id.open_drawer);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


// FOR NAVIGATION VIEW ITEM TEXT COLOR
        int[][] state = new int[][]{
                new int[]{-android.R.attr.state_enabled}, // disabled
                new int[]{android.R.attr.state_enabled}, // enabled
                new int[]{-android.R.attr.state_checked}, // unchecked
                new int[]{android.R.attr.state_pressed}  // pressed

        };

        int[] colors = new int[]{
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE,
                Color.WHITE
        };
        ColorStateList csl = new ColorStateList(state, colors);

        navigationView.setItemTextColor(csl);
        navigationView.setItemIconTintList(csl);

        openDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        if (savedInstanceState!=null && savedInstanceState.getString("currentFragment").equalsIgnoreCase("viewPDF")){
            //lood frament
            Fragment fragment = ViewPdfFragment.newInstance("book.pdf",ViewPdfFragment.pdfView.getCurrentPage()+1);
            loadFragment(fragment,"ViewPdf",false);
        }


       else if (savedInstanceState!=null && savedInstanceState.getString("currentFragment").equalsIgnoreCase("MangmentFragment")) {
            //lood frament
             Fragment fragment = new MangmentFragment();
            loadFragment(fragment,"mangment",false);

        } else if (savedInstanceState!=null && savedInstanceState.getString("currentFragment").equalsIgnoreCase("HomeFragment")) {
            //lood frament
             Fragment fragment = new HomeFragment();
            loadFragment(fragment,"home",false);
        } else if (savedInstanceState!=null && savedInstanceState.getString("currentFragment").equalsIgnoreCase("AboutUsFragment")) {
            //lood frament
             Fragment fragment = new AboutUsFragment();
            loadFragment(fragment,"aboutus",false);
        }
        else if (savedInstanceState!=null && savedInstanceState.getString("currentFragment").equalsIgnoreCase("ReportCaseFragment")) {
            //lood frament
             Fragment fragment = new ReportCaseFragment();
            loadFragment(fragment,"reportcase",false);
        }
        else if(savedInstanceState!=null && savedInstanceState.getString("currentFragment").equalsIgnoreCase("Foreword")){

            //lood frament
             Fragment fragment = ViewPdfFragment.newInstance("foreword.pdf",ViewPdfFragment.pdfView.getCurrentPage()+1);
            loadFragment(fragment,"ViewPdf",false);
        }

        else {
            //lood frament
            currentFragment = "HomeFragment";
            Fragment fragment = new HomeFragment();
            manager = getSupportFragmentManager();
            if (manager == null)
                manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();

            transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
            // transaction.replace(R.id.mainContent, fragment, "login").commit();
            transaction.replace(R.id.mainContent, fragment, "home").commit();

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentFragment", currentFragment);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.management) {
            //lood frament
            currentFragment = "MangmentFragment";
            Fragment fragment = new MangmentFragment();
            loadFragment(fragment,"mangment",true);

        } else if (id == R.id.home) {
            //lood frament
            currentFragment = "HomeFragment";
            Fragment fragment = new HomeFragment();
            loadFragment(fragment,"home",true);
        } else if (id == R.id.about) {
            //lood frament
            currentFragment = "AboutUsFragment";
            Fragment fragment = new AboutUsFragment();
            loadFragment(fragment,"aboutus",true);
        }
        else if (id == R.id.report_case) {
            //lood frament
            currentFragment = "ReportCaseFragment";
            Fragment fragment = new ReportCaseFragment();
           loadFragment(fragment,"reportcase",true);
        }
        else if(id == R.id.foreward_preface){

            //lood frament
            currentFragment = "Foreword";
            Fragment fragment = ViewPdfFragment.newInstance("foreword.pdf",1);
            loadFragment(fragment,"ViewPdf",true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment,String tag,boolean stack){

        manager = getSupportFragmentManager();
        if (manager == null)
            manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
        if (stack == true)
        transaction.replace(R.id.mainContent, fragment, tag).addToBackStack(tag).commit();
        else
            transaction.replace(R.id.mainContent, fragment, tag).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
