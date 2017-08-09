package com.example.apptrinhduyetmini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageButton ibtnBack;
    private ImageButton ibtnNext;
    private ImageButton ibtnReload;
    private EditText edtSearch;
    private Button btnSearch;
    private WebView wvWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWitget();
        wvWebView.setWebViewClient(new WebViewClient());
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edtSearch.getText().toString().trim();
                wvWebView.loadUrl("http://" + url);
                edtSearch.setText(wvWebView.getUrl());
            }
        });
        ibtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wvWebView.canGoBack()) {
                    wvWebView.goBack();
                    edtSearch.setText(wvWebView.getUrl());
                }else{
                    Toast.makeText(MainActivity.this, "Không có trang trước để trở về", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wvWebView.canGoForward()) {
                    wvWebView.goForward();
                    edtSearch.setText(wvWebView.getUrl());
                }else{
                    Toast.makeText(MainActivity.this, "Không có trang sau để đi tới", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ibtnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wvWebView.reload();
                edtSearch.setText(wvWebView.getUrl());
            }
        });
        WebSettings websettings = wvWebView.getSettings();//setting cho web
        websettings.setBuiltInZoomControls(true);// giúp thu phóng màn hình
        websettings.setDisplayZoomControls(false);//tắt icon thu phóng
        websettings.setJavaScriptEnabled(true);//cho phép bật các tính năng trong web

    }
    private void initWitget(){
        ibtnBack = (ImageButton) findViewById(R.id.ibtnBack);
        ibtnNext = (ImageButton) findViewById(R.id.ibtnNext);
        ibtnReload = (ImageButton) findViewById(R.id.ibtnReload);
        edtSearch = (EditText) findViewById(R.id.edtSearch);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        wvWebView = (WebView) findViewById(R.id.wvWebView);
    }
}
