package com.example.imad_a1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.userIn)
        val btnCheckAge = findViewById<Button>(R.id.btnSubmit)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val err = findViewById<TextView>(R.id.errorMsg)
        val resDisplay = findViewById<TextView>(R.id.resDisplay)

        val listOfCeleb = listOf(
            NameAge("Nelson Mandela", 95),
            NameAge("Robin Williams", 63),
            NameAge("Whitney Houston", 48),
            NameAge("Chadwick Boseman", 43),
            NameAge("Bernie Mac", 50),
            NameAge("Princess Diana", 36),
            NameAge("Chester Bennington", 41),
            NameAge("Amy Winehouse", 27),
            NameAge("Prince", 57),
            NameAge("Norm Macdonald", 61),
            NameAge("Bob Saget", 65),
            NameAge("Betty White", 99),
            NameAge("Aaliyah", 22),
        )

        btnClear.setOnClickListener {
            err.text = ""
            resDisplay.text = ""
            input.text.clear()
        }

        btnCheckAge.setOnClickListener {
            err.text = ""
            resDisplay.text = ""

            val ageIn = input.text.toString().toIntOrNull()
            if (ageIn != null){

                val res = checkAge(ageIn, listOfCeleb)
                when (res.status) {

                    200 -> resDisplay.text = "${res.nameAge?.name} passed away at the age of ${res.nameAge?.age}"
                    404 -> resDisplay.text = "No historical figure of the age ${ageIn} found"
                    400 -> err.text = "Please enter a number between 20 and 100"

                }
            }else{
                err.text = "Please enter a number"
            }
            input.text.clear()
        }


    }


}