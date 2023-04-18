package com.example.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var count = 0
    lateinit var diceImage : ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { countUp() }

        val imageButton: Button = findViewById(R.id.image_button)
        imageButton.setOnClickListener { rollDiceImage() }
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun countUp() {
        count += 1
        val countLabel: TextView = findViewById(R.id.count_label)
        countLabel.text = count.toString()
    }

    private fun rollDiceImage() {
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val randomInt = (1..6).random()
        val randomInt2 = (1..6).random()
        
        diceImage.setImageResource(getDiceImage(randomInt))
        diceImage2.setImageResource(getDiceImage(randomInt2))
    }
    
    private fun getDiceImage(randomInt: Int): Int {
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }


}