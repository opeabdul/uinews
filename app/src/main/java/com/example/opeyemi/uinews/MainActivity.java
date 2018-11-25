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
    Toast toast;//Toast to nofify user of WebView Loading

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
                    cancelToast();
                    toast = Toast.makeText(MainActivity.this, "UI News Loading...", Toast.LENGTH_SHORT);
                    toast.show();
                    setFragment(newsFragment);
                    break;
                case R.id.action_bulletin:
                    cancelPreviousToast();
                    toast = Toast.makeText(MainActivity.this, "UI Bullettins Loading...", Toast.LENGTH_SHORT);
                    toast.show();
                    setFragment(bulletinFragment);
                    break;
                case R.id.action_information:
                    cancelPreviousToast();
                    setFragment(aboutFragment);
                    break;
            }
            return true;
        }
    }

    //method to cancel previous toast for the display of another toast
    private void cancelPreviousToast() {
        if (toast != null){
            toast.cancel();
        }
    }
}
