package com.example.smilemini.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.smilemini.Base.BaseAct
import com.example.smilemini.LoginAct
import com.example.smilemini.R

class Splash_Act : BaseAct() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed(
            {
            startActivity( Intent(applicationContext, LoginAct::class.java))

            finish()

            },3000)
    }
}
