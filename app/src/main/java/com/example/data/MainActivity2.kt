package com.example.data

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.data.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    private lateinit var secbinding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
        secbinding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(secbinding.root)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)

        val bundle=intent.extras
        secbinding.saveButton.setOnClickListener(){
            val first=bundle!!.getString("day")
            val sec=bundle!!.getString("date")
            val third=bundle!!.getString("amount")

            val editor: SharedPreferences. Editor =  sharedPreferences.edit()
            editor.putString("day",first)
            editor.putString("date",sec)
            editor.putString("amount",third)
            editor.apply()
            editor.commit()
        }


        secbinding.viewButton.setOnClickListener(){
            val daydata=sharedPreferences.getString("day","000000")
            secbinding.txtDay.text=daydata
            val datedata=sharedPreferences.getString("date","00000")
            secbinding.txtDate.text=datedata
            val amtdata=sharedPreferences.getString("amount","000000")
            secbinding.txtAmount.text=amtdata

        }

        secbinding.clearButton.setOnClickListener(){
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
            secbinding.txtDay.text=""
            secbinding.txtDate.text=""
            secbinding.txtAmount.text=""
        }
    }
}