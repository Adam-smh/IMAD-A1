package com.example.imad_a1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ids given var
        val input = findViewById<EditText>(R.id.userIn)
        val btnCheckAge = findViewById<Button>(R.id.btnSubmit)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val err = findViewById<TextView>(R.id.errorMsg)
        val resDisplay = findViewById<TextView>(R.id.resDisplay)
        val smlCrd = findViewById<CardView>(R.id.smlCard)

        //Hardcoded list of history figures
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
        //Clear button setting all fields and text to default
        btnClear.setOnClickListener {
            err.text = ""
            resDisplay.text = ""
            input.text.clear()
            smlCrd.setCardBackgroundColor(ContextCompat.getColor(this, R.color.bg));         }

        //check age func
        btnCheckAge.setOnClickListener {
            //defaulting errors and disp text
            err.text = ""
            resDisplay.text = ""
            smlCrd.setCardBackgroundColor(Color.parseColor("#E7D2A6"))

            //convert input to int
            val ageIn = input.text.toString().toIntOrNull()
            //verifying conversion
            if (ageIn != null){

                val res = checkAge(ageIn, listOfCeleb)
                //switch case between status codes
                when (res.status) {
                    //Okay, display matching age and details
                    200 -> {
                        smlCrd.setBackgroundColor(ContextCompat.getColor(this, R.color.smlBg));
                        resDisplay.text = "${res.nameAge?.name} passed away at the age of ${res.nameAge?.age}"
                        resDisplay.setBackgroundColor(Color.parseColor("#F5E3BD"))
                    }

                    //not found
                    404 ->{
                        resDisplay.text = "No historical figure of the age ${ageIn} found"
                        resDisplay.setBackgroundColor(Color.parseColor("#F5E3BD"))
                    }

                    //user err
                    400 -> err.text = "Please enter a number between 20 and 100"
                }
            }else{
                //if conversion fails user is asked to enter num
                err.text = "Please enter a number"
            }
            //keep input clear
            input.text.clear()
        }
    }
}