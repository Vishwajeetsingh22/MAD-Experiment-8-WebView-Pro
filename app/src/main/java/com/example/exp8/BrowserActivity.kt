@file:Suppress("SpellCheckingInspection")

package com.example.exp8

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback

class BrowserActivity : ComponentActivity() {

    private lateinit var webView: WebView
    private lateinit var etBrowserUrl: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var btnBack: ImageButton
    private lateinit var btnForward: ImageButton
    private lateinit var btnReload: ImageButton
    private lateinit var btnBrowserMenu: ImageButton

    private var filePathCallback: ValueCallback<Array<Uri>>? = null
    private val FILE_CHOOSER_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        webView = findViewById(R.id.webViewPro)
        etBrowserUrl = findViewById(R.id.etBrowserUrl)
        progressBar = findViewById(R.id.progressBar)
        btnBack = findViewById(R.id.btnBack)
        btnForward = findViewById(R.id.btnForward)
        btnReload = findViewById(R.id.btnReload)
        btnBrowserMenu = findViewById(R.id.btnBrowserMenu)

        setupWebView()
        setupListeners()
        setupBackPressHandler()

        val initialUrl = intent.getStringExtra("URL") ?: "https://www.wikipedia.org"
        etBrowserUrl.setText(initialUrl)
        webView.loadUrl(initialUrl)
    }

    private fun setupBackPressHandler() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    finish()
                }
            }
        })
    }

    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.loadsImagesAutomatically = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: android.graphics.Bitmap?) {
                super.onPageStarted(view, url, favicon)
                progressBar.visibility = View.VISIBLE
                url?.let { etBrowserUrl.setText(it) }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressBar.visibility = View.GONE
            }

            override fun onReceivedError(
                view: WebView?,
                request: android.webkit.WebResourceRequest?,
                error: android.webkit.WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                progressBar.visibility = View.GONE
                Toast.makeText(this@BrowserActivity, "Failed to load page. Check connection.", Toast.LENGTH_SHORT).show()
            }
        }

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                progressBar.progress = newProgress
                if (newProgress == 100) {
                    progressBar.visibility = View.GONE
                }
            }

            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                this@BrowserActivity.filePathCallback = filePathCallback
                val intent = fileChooserParams?.createIntent()
                try {
                    intent?.let { startActivityForResult(it, FILE_CHOOSER_REQUEST_CODE) }
                } catch (e: Exception) {
                    this@BrowserActivity.filePathCallback = null
                    return false
                }
                return true
            }
        }
    }

    private fun setupListeners() {
        btnBack.setOnClickListener {
            if (webView.canGoBack()) webView.goBack()
        }

        btnForward.setOnClickListener {
            if (webView.canGoForward()) webView.goForward()
        }

        btnReload.setOnClickListener {
            webView.reload()
        }

        etBrowserUrl.setOnEditorActionListener { _, _, _ ->
            var url = etBrowserUrl.text.toString().trim()
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = if (url.contains(".")) "https://$url" else "https://www.google.com/search?q=$url"
            }
            webView.loadUrl(url)
            true
        }

        btnBrowserMenu.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menu.add(0, 1, 0, "Home")
            popup.menu.add(0, 2, 1, "Share Page")
            popup.menu.add(0, 3, 2, "Student Info (About)")
            popup.menu.add(0, 4, 3, "Settings")
            popup.menu.add(0, 5, 4, "Exit")

            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    1 -> {
                        finish()
                        true
                    }
                    2 -> {
                        val shareIntent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, webView.url ?: "https://www.wikipedia.org")
                            type = "text/plain"
                        }
                        startActivity(Intent.createChooser(shareIntent, "Share URL via"))
                        true
                    }
                    3 -> {
                        showAboutDialog()
                        true
                    }
                    4 -> {
                        startActivity(Intent(this, SettingsActivity::class.java))
                        true
                    }
                    5 -> {
                        finishAffinity()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Student Information")
            .setMessage("Name: Vishwajeet Singh\nUSN: 25MCAR0219\nMCA - Jain University\nApp: WebView Pro")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}