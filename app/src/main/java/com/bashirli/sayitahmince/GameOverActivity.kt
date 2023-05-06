package com.bashirli.sayitahmince

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bashirli.sayitahmince.databinding.ActivityGameOverBinding

class GameOverActivity : AppCompatActivity() {

    private lateinit var binding:ActivityGameOverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGameOverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val status=intent.getBooleanExtra("result",false)

        if(status){
            binding.textViewEnd.setText("Win")
            binding.imageView.setImageResource(R.drawable.smile)
        }else{
            binding.textViewEnd.setText("Lose")
            binding.imageView.setImageResource(R.drawable.sadsmile)
        }

        binding.buttonMain.setOnClickListener {
            returnToMain()
        }

        binding.buttonRestart.setOnClickListener {
            restartGame()
        }

    }

    fun returnToMain(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun restartGame(){
        val intent=Intent(applicationContext,GameActivity::class.java)
        startActivity(intent)
        finish()
    }

}