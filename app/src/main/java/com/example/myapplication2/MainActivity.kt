package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.SearchView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication2.ui.theme.MyApplication2Theme


class MainActivity : ComponentActivity() {

    lateinit var webView:WebView
    private var savedText:String=""

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchView=findViewById<SearchView>(R.id.searchView) as SearchView
        val button=findViewById<Button>(R.id.btnSave) as Button
        val webView=findViewById<WebView>(R.id.webView) as WebView
        button.setOnClickListener{
            savedText=searchView.query.toString()
            webView.loadUrl(savedText)
            webView.settings.javaScriptEnabled=true
            webView.webViewClient = WebViewClient()
            webView.settings.setSupportZoom(true)
        }




    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(webView.canGoBack()){
            webView.goBack()
        }else{
            finish()
        }
    }


}
