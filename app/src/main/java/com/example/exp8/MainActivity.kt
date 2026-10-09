@file:Suppress("SpellCheckingInspection")

package com.example.exp8

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout

class MainActivity : Activity() {

    private lateinit var etUrlInput: EditText
    private lateinit var btnOpenWebsite: Button
    private lateinit var btnSettingsMenu: ImageView
    private lateinit var cardWikipedia: LinearLayout
    private lateinit var cardGoogle: LinearLayout
    private lateinit var cardGithub: LinearLayout
    private lateinit var cardAbout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUrlInput = findViewById(R.id.etUrlInput)
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite)
        btnSettingsMenu = findViewById(R.id.btnSettingsMenu)
        cardWikipedia = findViewById(R.id.cardWikipedia)
        cardGoogle = findViewById(R.id.cardGoogle)
        cardGithub = findViewById(R.id.cardGithub)
        cardAbout = findViewById(R.id.cardAbout)

        setupListeners()
    }

    private fun setupListeners() {
        btnOpenWebsite.setOnClickListener {
            openBrowser(etUrlInput.text.toString().trim())
        }

        etUrlInput.setOnEditorActionListener { _, _, _ ->
            openBrowser(etUrlInput.text.toString().trim())
            true
        }

        btnSettingsMenu.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        cardWikipedia.setOnClickListener {
            openBrowser("https://www.wikipedia.org")
        }

        cardGoogle.setOnClickListener {
            openBrowser("https://www.google.com")
        }

        cardGithub.setOnClickListener {
            openBrowser("https://github.com")
        }

        cardAbout.setOnClickListener {
            showAboutDialog()
        }
    }

    private fun openBrowser(url: String) {
        var targetUrl = url
        if (targetUrl.isEmpty()) {
            targetUrl = "https://www.wikipedia.org"
        } else if (!targetUrl.startsWith("http://") && !targetUrl.startsWith("https://")) {
            targetUrl = if (targetUrl.contains(".")) "https://$targetUrl" else "https://www.google.com/search?q=$targetUrl"
        }

        val intent = Intent(this, BrowserActivity::class.java).apply {
            putExtra("URL", targetUrl)
        }
        startActivity(intent)
    }

    private fun showAboutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Student Information & About")
            .setMessage("App: WebView Pro\nName: Vishwajeet Singh\nUSN: 25MCAR0219\nMCA - Jain University\n\nA professional high-performance mobile web application.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .setNegativeButton("Exit App") { _, _ -> finish() }
            .show()
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit WebView Pro")
            .setMessage("Are you sure you want to exit the application?")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No", null)
            .show()
    }
}