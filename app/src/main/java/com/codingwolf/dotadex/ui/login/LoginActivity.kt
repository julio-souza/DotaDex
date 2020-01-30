package com.codingwolf.dotadex.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codingwolf.dotadex.App
import com.codingwolf.dotadex.R

class LoginActivity : AppCompatActivity() {

    val loginComponent by lazy { (application as App).appComponent.loginComponent().create() }

    override fun onCreate(savedInstanceState: Bundle?) {
        loginComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
