package com.bashirli.sayitahmince

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bashirli.sayitahmince.databinding.ActivityGameBinding
import java.util.Random

class GameActivity : AppCompatActivity() {
    private lateinit var binding:ActivityGameBinding
    private var myNumber:Int=0
    private var haqq=5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val random= Random()
        myNumber=random.nextInt(100)

        binding.buttonFind.setOnClickListener {
        findNumber()
        }

    }

    private fun findNumber(){
        val number=binding.editTextNumber.text.toString()

        if(number.isEmpty()){
            Toast.makeText(applicationContext,"Enter the number", Toast.LENGTH_LONG).show()
            return
        }

        if(myNumber>number.toInt()){
            binding.textViewKomek.setText("Higher")
        }else if(myNumber<number.toInt()){
            binding.textViewKomek.setText("Lower")
        }else{
            val intent= Intent(this,GameOverActivity::class.java)
            intent.putExtra("result",true)
            startActivity(intent)
            finish()
            return
        }

        haqq--
        binding.textViewHaqq.setText("Haqqimiz : $haqq")

        if(haqq==0){
            val intent=Intent(applicationContext,GameOverActivity::class.java)
            intent.putExtra("result",false)
            startActivity(intent)
            finish()
        }

    }

}