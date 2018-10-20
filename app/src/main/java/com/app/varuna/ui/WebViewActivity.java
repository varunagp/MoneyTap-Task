package com.app.varuna.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.app.varuna.R;
import com.app.varuna.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.help_webview)
    WebView webview;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private String URLToLoad = "";
    private String pageTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.app_name);

        if (getIntent().getExtras() != null) {
            URLToLoad = getIntent().getStringExtra("URL");
        }

        if (Utils.haveNetworkConnection(this)) {
            webview.setWebViewClient(new MyWebViewClient());
            WebSettings settings = webview.getSettings();
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            openURL();
        } else {
            Toast.makeText(WebViewActivity.this, "Please check your internet connection and try again", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openURL() {
        webview.loadUrl(URLToLoad);
        webview.requestFocus();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
