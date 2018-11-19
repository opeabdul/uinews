package com.example.opeyemi.uinews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView uiNewsHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiNewsHome = new WebView(MainActivity.this);
        setContentView(uiNewsHome);
        uiNewsHome.loadUrl("https://www.ui.edu.ng/news");
        WebViewClient myWebviewClient = new WebViewClient();
        uiNewsHome.setWebViewClient(myWebviewClient);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && uiNewsHome.canGoBack()) {
            uiNewsHome.goBack();
        };
        return super.onKeyDown(keyCode, event);
    }
}
