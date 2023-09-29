package com.dicoding.ngaos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Splash Screen
        Thread.sleep(3000)
        installSplashScreen()

        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.StartButton)
        btnStart.setOnClickListener(this)

        val btnAbout: Button = findViewById(R.id.AboutButton)
        btnAbout.setOnClickListener(this)

        val btnExit: Button = findViewById(R.id.ExitButton)
        btnExit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.StartButton -> {
                val myintent = Intent(this@MainActivity, ContentActivity::class.java)
                startActivity(myintent)
            }

            R.id.AboutButton -> {
                val myintent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(myintent)
            }

            R.id.ExitButton -> {
                this@MainActivity.finish()
                exitProcess(0)
            }
        }
    }

}