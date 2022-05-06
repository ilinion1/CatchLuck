package com.playrix.gardensca.presentation.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.playrix.gardensca.databinding.ActivitySecondsBinding

class SecondsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondsBinding
    private var fileData: ValueCallback<Uri>? = null
    private var filePath: ValueCallback<Array<Uri>>? = null
    private lateinit var startForResult: ActivityResultLauncher<Intent>
    private lateinit var link: String
    private var count1 = 0
    private var count2 = 0
    private var count3 = 0
    private var count4 = 0
    private var count5 = 0
    private var count6 = 0
    private var count7 = 0
    private var count8 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (count1 == 0){
            intent.getStringExtra("link")?.let { link = it }
            startWebView()
            startResultLauncher()
        }else{
            if (count8 == 0){
                Log.d("test1","test")
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun startWebView() = with(binding) {
        if (count1 == 0) {
            webView.loadUrl(link)
            webView.settings.javaScriptEnabled = true
            webView.settings.domStorageEnabled = true
            webView.settings.loadWithOverviewMode = true
            webView.clearCache(false)
            webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
            CookieManager.getInstance().setAcceptCookie(true)
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
            webView.webChromeClient = ChromeClient()
            webView.webViewClient = WebViewClient()
        }else{
            if (count7 == 0){
                Log.d("test1","test")
            }
        }
    }



    private inner class ChromeClient : WebChromeClient() {
        override fun onShowFileChooser(
            webView: WebView?, filePathCallback: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            if (count3 == 0) {
                filePath = filePathCallback
                launchResult()
            }
            return true
        }
    }


    private fun launchResult() {
        if (count4 == 0) {
            val i = Intent(Intent.ACTION_GET_CONTENT)
            i.addCategory(Intent.CATEGORY_OPENABLE)
            i.type = "image/*"
            startForResult.launch(i)
        } else{
            if (count6 == 0){
                Log.d("test1","test")
            }
        }
    }

    private fun startResultLauncher() {
        if (count5 == 0) {
            startForResult =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    if (fileData == null && filePath == null) return@registerForActivityResult
                    val resultFileData: Uri?
                    val resultsFilePath: Array<Uri>?
                    if (result.data == null) {
                        resultFileData = null
                        resultsFilePath = null
                    } else {
                        resultFileData = result.data?.data
                        resultsFilePath = arrayOf(Uri.parse(result.data?.dataString))
                    }
                    fileData?.onReceiveValue(resultFileData)
                    filePath?.onReceiveValue(resultsFilePath)
                }
        }else{
            if (count2 == 0){
                Log.d("test1","test")
            }
        }
    }

    override fun onBackPressed() {
        if (count6 == 0) {
            if (binding.webView.canGoBack()) {
                binding.webView.goBack()
            } else {
                return
            }
        }
    }
}