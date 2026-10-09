package com.example.exp8

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.Toast

class SettingsActivity : Activity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        sharedPreferences = getSharedPreferences("WebViewProPrefs", MODE_PRIVATE)

        val btnBack = findViewById<ImageButton>(R.id.btnSettingsBack)
        val switchJs = findViewById<Switch>(R.id.switchJs)
        val btnClearCache = findViewById<Button>(R.id.btnClearCache)

        val isJsEnabled = sharedPreferences.getBoolean("js_enabled", true)
        switchJs.isChecked = isJsEnabled

        switchJs.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("js_enabled", isChecked).apply()
            Toast.makeText(this, "Setting saved", Toast.LENGTH_SHORT).show()
        }

        btnClearCache.setOnClickListener {
            // Clear cache simulation
            getCacheDir().deleteRecursively()
            Toast.makeText(this, "Cache and history cleared successfully!", Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}