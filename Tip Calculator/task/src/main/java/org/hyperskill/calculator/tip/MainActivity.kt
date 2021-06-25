package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView = findViewById<View>(R.id.text_view) as TextView
        val mySlider = findViewById<Slider>(R.id.slider)
        val myEditText = findViewById<EditText>(R.id.edit_text)

        myEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                if (s.toString() != "") {
                    myTextView.text = "Tip amount: ${"%.2f".format(s.toString().toDouble() * mySlider.value.toInt() / 100.0)}"
                } else {
                    myTextView.text = ""
                }
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        mySlider.addOnChangeListener { slider, value, fromUser ->
            if (myEditText.text.toString() != "") {
                myTextView.text = "Tip amount: ${"%.2f".format(myEditText.text.toString().toDouble() * mySlider.value.toInt() / 100.0)}"
            }
        }
    }
}