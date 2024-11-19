package com.sonya.mfirstgame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var changeText: TextView
    private lateinit var wordText: TextView
    private lateinit var picImgView: ImageView
    private lateinit var buttons: Array<Button>


    private val images = arrayOf(R.drawable.picture2, R.drawable.picture3,R.drawable.win)
    private val words = arrayOf(R.string.Word_Minion, R.string.Word_Kegla,R.string.Win)
    private val toastMessages = arrayOf("Первый уровень завершен", "Второй уровень завершен", "Третий уровень завершен")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordText = findViewById(R.id.textView)
        changeText = findViewById(R.id.textViewWordToFind)
        picImgView = findViewById(R.id.pictureImageView)
        buttons = arrayOf(
            findViewById(R.id.buttonFind1),
            findViewById(R.id.buttonFind2),
            findViewById(R.id.buttonFind3)
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener { onButtonClick(index) }
        }
    }

    private fun onButtonClick(buttonIndex: Int) {
        if (buttonIndex < images.size && buttonIndex < words.size) {
            imgAndPicChange(buttonIndex)
            newLvl(toastMessages[buttonIndex])

            if (buttonIndex < buttons.size - 1) {
                buttons[buttonIndex].visibility = View.GONE
                buttons[buttonIndex + 1].visibility = View.VISIBLE
            } else {
                wordText.visibility = View.GONE
            }
        }
    }

    private fun imgAndPicChange(index: Int) {
        picImgView.setImageResource(images[index])
        changeText.text = getString(words[index])
    }

    private fun newLvl(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

}

