package com.example.emplicitintentdemo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        (findViewById<Button>(R.id.btnSend)).setOnClickListener(buttonClick)
        (findViewById<Button>(R.id.btnCall)).setOnClickListener(buttonClick)
        (findViewById<Button>(R.id.btnOtherActivity)).setOnClickListener(buttonClick)


    }
    private val buttonClick: (View) -> Unit = {view ->
        when(view.id){
            R.id.btnSend ->{
                val message = (findViewById<EditText>(R.id.messageField)).text.toString()

                val messageIntent = Intent(applicationContext, MessageActivity::class.java)
                messageIntent.putExtra("MAIN_ACTIVITY_MSG", message)
                startActivity(messageIntent)

                (findViewById<EditText>(R.id.messageField)).setText("")
            }

            R.id.btnCall ->{
                val phone: Uri = Uri.parse("tel:911")
                val callIntent:Intent = Intent(Intent.ACTION_DIAL, phone)
                startActivity(callIntent)
            }
            R.id.btnOtherActivity ->{
                val newIntent = Intent("other.android.intent.action.MY_ACTIVITY")
                startActivity(newIntent)
            }
        }
    }

}
