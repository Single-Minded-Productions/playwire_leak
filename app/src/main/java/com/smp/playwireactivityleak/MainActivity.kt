package com.smp.playwireactivityleak

import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.multidex.BuildConfig
import com.intergi.playwiresdk.PlaywireSDK
import java.util.concurrent.atomic.AtomicBoolean

private val isPlaywireInitialized = AtomicBoolean(false)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initPlaywire()
    }

    private fun initPlaywire() {
        if (isPlaywireInitialized.getAndSet(true)) {
            return
        }
        Log.d("PlaywireSDK", "Playwire SDK beginning initialization")
        PlaywireSDK.initialize("PLACEHOLDER-REPLACE", "PLACEHOLDER-REPLACE", this) {
            Log.d("PlaywireSDK", "Playwire SDK initialized")
        }

    }
}