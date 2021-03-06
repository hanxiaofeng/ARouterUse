package com.xinshiyun.arouterhomedemo.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xinshiyun.arouterhomedemo.R;

@Route(path = "/web/webviewActivity")
public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        initView();
    }

    private void initView() {
        webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/testUrl.html");
    }
}
