package com.example.opeyemi.uinews;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView uiNewsHome;
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiNewsHome = new WebView(MainActivity.this);
        setContentView(R.layout.activity_main);


        //get layout and load web contents
        uiNewsHome = (WebView) findViewById(R.id.webview);
        uiNewsHome.loadUrl("https://www.ui.edu.ng/news");

        //handling navigations within the application
        WebViewClient myWebviewClient = new WebViewClient();
        uiNewsHome.setWebViewClient(myWebviewClient);


        //get bottom navigation instance and set listener
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        NavigationSelectedListener navigationSelectedListener = new NavigationSelectedListener();
        navigation.setOnNavigationItemSelectedListener(navigationSelectedListener);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && uiNewsHome.canGoBack()) {
            uiNewsHome.goBack();
        };
        return super.onKeyDown(keyCode, event);
    }

    //listener interface for the bottom navigation when selected
    private class NavigationSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.action_news:
                    Toast.makeText(MainActivity.this, "News was clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_bulletin:
                    Toast.makeText(MainActivity.this, "Bullettin was clicked", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_information:
                    Toast.makeText(MainActivity.this, "Information was clicked", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    }
}
