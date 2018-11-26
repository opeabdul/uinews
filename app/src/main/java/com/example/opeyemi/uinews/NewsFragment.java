package com.example.opeyemi.uinews;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private WebView uiNewsHomepage;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        uiNewsHomepage = new WebView(getContext());

        //Get layout and load web contents
        View newsFragmentLayout = inflater.inflate(R.layout.fragment_news,container,false);

        uiNewsHomepage = (WebView) newsFragmentLayout.findViewById(R.id.webview);
        uiNewsHomepage.loadUrl("https://www.ui.edu.ng/news");
        Log.e("NewsFrgment","It runned the loadurl");
        //Handling navigations within the application
        WebViewClient myWebviewClient = new WebViewClient();
        uiNewsHomepage.setWebViewClient(myWebviewClient);
        return newsFragmentLayout;
    }

}
