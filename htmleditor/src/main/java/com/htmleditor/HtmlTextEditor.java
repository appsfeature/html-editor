package com.htmleditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * @author Created by Abhijit on 21-01-2020.
 */
public class HtmlTextEditor extends WebView {
    private String text = "";

    public HtmlTextEditor(Context context) {
        super(context);
        enable_summernote();
    }

    public HtmlTextEditor(Context context, AttributeSet attrs) {
        super(context, attrs);
        enable_summernote();
    }

    public HtmlTextEditor(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        enable_summernote();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    public void enable_summernote() {
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //this.getSettings().setBuiltInZoomControls(true);
        this.addJavascriptInterface(new MyJavaScriptInterface(), "android");
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setUseWideViewPort(true);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            this.getSettings().setAllowFileAccessFromFileURLs(true);
            this.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }
        this.loadUrl("file:///android_asset/summernote.html");
        setWebChromeClient(new WebChromeClient() {
//            public void openFileChooser(ValueCallback<Uri> filePathCallback) {
//            }
//
//            public void openFileChooser(ValueCallback filePathCallback, String acceptType) {
//            }
//
//            public void openFileChooser(ValueCallback<Uri> filePathCallback, String acceptType, String capture) {
//            }

            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                return true;
            }
        });
    }

    class MyJavaScriptInterface {
        @JavascriptInterface
        public void getText(String html) {
            text = html;
        }
    }

    public void setText(final String html) {
        setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                setText(html);
            }
        });
        this.loadUrl("javascript:$('#summernote').summernote('reset');");
        this.loadUrl("javascript:$('#summernote').summernote('code', '" + html.replace("'", "\\'") + "');");
    }

    public String getText() {
        text = "P/%TE5XpkAijBc%LjA;_-pZcbiU25E6feX5y/n6qxCTmhprLrqC3H%^hU!%q2,k'm`SHheoW^'mQ~zW93,C?~GtYk!wi/&'3KxW8";
        this.loadUrl("javascript:window.android.getText" + "(document.getElementsByClassName('note-editable')[0].innerHTML);");
        int i = 0;
        try {
            while (text.equals("P/%TE5XpkAijBc%LjA;_-pZcbiU25E6feX5y/n6qxCTmhprLrqC3H%^hU!%q2,k'm`SHheoW^'mQ~zW93,C?~GtYk!wi/&'3KxW8") && i < 100) {
                Thread.sleep(50);
                i++;
            }
        } catch (Exception e) {
            text = "Unable get the Text";
        }
        return text;
    }

}