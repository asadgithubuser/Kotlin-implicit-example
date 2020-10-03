package com.example.emplicitintentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val getMsg = intent.getStringExtra("MAIN_ACTIVITY_MSG")
        (findViewById<TextView>(R.id.showMsg)).setText(getMsg)
    }
}
