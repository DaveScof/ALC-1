package com.company.alc1;

import android.app.ProgressDialog;
import android.net.http.SslError;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutAlcActivity extends AppCompatActivity {

    public static final String ALC_ABOUT_PAGE = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);


        WebView webview = findViewById(R.id.webView_about_alc);

        final ProgressDialog progressDialog = ProgressDialog.show(this, "", "Loading...",true);


        webview.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(AboutAlcActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError er) {
                handler.proceed();
                // Ignore SSL certificate errors
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if(progressDialog!=null && progressDialog.isShowing())
                {
                    progressDialog.dismiss();
                }
            }
        });

        webview.getSettings().setUserAgentString("Android");


        webview.loadUrl(ALC_ABOUT_PAGE);
    }
}
