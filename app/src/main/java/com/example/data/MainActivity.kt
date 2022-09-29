package com.example.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.data.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveData.setOnClickListener(){

            val bundle=Bundle()

            val ed_day=binding.edDay.text.toString()
            val ed_dat=binding.edDate.text.toString()
            val ed_amt=binding.edAmt.text.toString()
            bundle.putString("day",ed_day)
            bundle.putString("date",ed_dat)
            bundle.putString("amount",ed_amt)
            val intent=Intent(this@MainActivity,MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }
    }
}