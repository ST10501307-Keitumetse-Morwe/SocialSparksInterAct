package com.example.socialsparksinteract

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //button declarations
        val tvName = findViewById<TextView>(R.id.tvName)
        val etTimeOfDaySlot = findViewById<EditText>(R.id.etTimeOfDaySlot)
        val tvTimeOfDay = findViewById<TextView>(R.id.tvTimeOfDaySlot)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val btnShowSuggestion = findViewById<Button>(R.id.btnShowSuggestion)

        val suggestions = arrayOf("Morning", "Mid-Morning", "Afternoon", "Afternoon Snack Time", "Dinner", "After Dinner")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, suggestions)
        etTimeOfDaySlot.setOnClickListener { adapter }


        btnShowSuggestion.setOnClickListener {

            val etTimeOfDaySlot = etTimeOfDaySlot.text.toString()

            val suggestion = when (etTimeOfDaySlot) {
                "Morning" -> "Send a 'Good Morning' text to a family member"
                "Mid-Morning" -> "Reach out to a colleague with a quick 'Thank You'"
                "Afternoon" -> "Share a funny meme or interesting link with a freind"
                "Afternoon Snack Time" -> "Send a quick 'thinking of you' message"
                "Dinner" -> "Call a freind or relative fpr a 5 minute catch up"
                "After Dinner" -> "Leave a thoughtful comment on a freind's post"
                else -> "Please enter one of the available time inputs"
            }

            tvResult.text = suggestion
        }

        btnReset.setOnClickListener {
            tvResult.text = ""
            etTimeOfDaySlot.text.clear()
        }









        }
    }
