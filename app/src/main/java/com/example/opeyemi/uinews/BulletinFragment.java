package com.example.opeyemi.uinews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class BulletinFragment extends Fragment {

    private WebView uiBulletinHomepage;

    public BulletinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View bulletinFragmentLayout = inflater.inflate(R.layout.fragment_bulletin, container, false);
        uiBulletinHomepage = bulletinFragmentLayout.findViewById(R.id.ui_bulletin_homepage);
        uiBulletinHomepage.loadUrl("https://bulletin.ui.edu.ng/");
        WebViewClient webViewClient = new WebViewClient(); //web view loads within the app
        uiBulletinHomepage.setWebViewClient(webViewClient);
        return bulletinFragmentLayout;
    }

}
