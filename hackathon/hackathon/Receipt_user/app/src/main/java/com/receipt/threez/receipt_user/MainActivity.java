package com.receipt.threez.receipt_user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.receipt.threez.receipt_user.data.Item;
import com.receipt.threez.receipt_user.data.Receipt;
import com.receipt.threez.receipt_user.util.FragmentUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentUtil {
    private Menu menu;
    private static final int MENU_REPRESH = Menu.FIRST + 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment defaultFragment = ReceiptFragment.newInstance();
        setFragment(defaultFragment);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        menu.add(MENU_REPRESH, MENU_REPRESH + 1, Menu.NONE, "새로고침").setIcon(getResources().getDrawable(R.drawable.ic_cached_black_24dp));
        menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == MENU_REPRESH + 1) {
            ReceiptFragment.getReceiptInfo();
            Toast.makeText(this, "새로고침", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment newFragment = ReceiptFragment.newInstance();;
        if (id == R.id.nav_receipt) {
            newFragment = ReceiptFragment.newInstance();
            menu.add(MENU_REPRESH, MENU_REPRESH + 1, Menu.NONE, "새로고침").setIcon(getResources().getDrawable(R.drawable.ic_cached_black_24dp));
            menu.getItem(0).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        } else if (id == R.id.nav_consumption_report) {
            newFragment = ConsumptionReportFragment.newInstance();
            menu.removeItem(MENU_REPRESH + 1);
        } else if (id == R.id.nav_recommendation) {
            newFragment = RecommendationFragment.newInstance();
            menu.removeItem(MENU_REPRESH + 1);
        }
        setFragment(newFragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }
}
