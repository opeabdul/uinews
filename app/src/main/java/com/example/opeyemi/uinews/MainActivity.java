package com.example.opeyemi.uinews;

import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigation;


    BulletinFragment bulletinFragment;
    NewsFragment newsFragment;
    AboutFragment aboutFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //get fragment instances
        newsFragment = new NewsFragment();
        bulletinFragment = new BulletinFragment();
        aboutFragment = new AboutFragment();

        setFragment(newsFragment);

        //get bottom navigation instance and set listener
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        NavigationSelectedListener navigationSelectedListener = new NavigationSelectedListener();
        navigation.setOnNavigationItemSelectedListener(navigationSelectedListener);



    }


    //sets the fragment to be displayed
    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
/**
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && uiNewsHome.canGoBack()) {
            uiNewsHome.goBack();
        };
        return super.onKeyDown(keyCode, event);
    }
 **/
    //listener interface for the bottom navigation when selected
    private class NavigationSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.action_news:
                    Toast.makeText(MainActivity.this, "News was clicked", Toast.LENGTH_SHORT).show();
                    setFragment(newsFragment);
                    break;
                case R.id.action_bulletin:
                    Toast.makeText(MainActivity.this, "Bullettin was clicked", Toast.LENGTH_SHORT).show();
                    setFragment(bulletinFragment);
                    break;
                case R.id.action_information:
                    Toast.makeText(MainActivity.this, "Information was clicked", Toast.LENGTH_SHORT).show();
                    setFragment(aboutFragment);
                    break;
            }
            return true;
        }
    }
}
