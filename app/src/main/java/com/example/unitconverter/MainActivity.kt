package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setting dropdown options by creating an ArrayAdapter and setting it to the dropdowns.
        var inputSpinner: Spinner = findViewById(R.id.spinner)
        var outputSpinner: Spinner = findViewById(R.id.spinner2)
        // Creating an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.cooking_units,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            inputSpinner.adapter = adapter
            outputSpinner.adapter = adapter
        }
        var convertBtn:Button =findViewById(R.id.button);
        var outputText:TextView =findViewById(R.id.outputfield);

        //listener that calls the convert method and displays the result in a TextView.
        convertBtn.setOnClickListener{
            var inputUnitSpinner: Spinner = findViewById(R.id.spinner)
            var outputUnitSpinner: Spinner = findViewById(R.id.spinner2)
            var inputValueText:EditText = findViewById(R.id.conversionunits)
            var inputUnit:String = inputUnitSpinner.selectedItem.toString()
            var outputUnit:String = outputUnitSpinner.selectedItem.toString()
            val inputValue = inputValueText.text.toString().toDouble()

            val result = convert(inputValue, inputUnit, outputUnit)
            outputText.text = result.toString()

        }
    }

    /**
     * method that converts the input value from the selected input unit to the selected output unit.
     */
    private fun convert(value: Double, inputSpinner: String, outputSpinner: String): Double {

            var result = 0.0
            when (inputSpinner) {
                "milliliters" -> {
                    when (outputSpinner) {
                        "milliliters" -> result = value
                        "ounces" -> result = value * 0.033814
                    }
                }
                "ounces" -> {
                    when (outputSpinner) {
                        "milliliters" -> result = value * 29.5735
                        "ounces" -> result = value
                    }
                }
                "grams" -> {
                    when (outputSpinner) {
                        "grams" -> result = value
                        "cups" -> result = value / 201
                    }
                }
                "cups" -> {
                    when (outputSpinner) {
                        "grams" -> result = value * 201
                        "cups" -> result = value
                        "tablespoon" -> result = value * 16
                    }
                }
                "tablespoon" -> {
                    when (outputSpinner) {
                        "tablespoon" -> result = value
                        "quarts" -> result = value / 0.015625
                        "cups" -> result = value / 16
                        "milliliters" -> result = value*15
                    }
                }
                "quarts" -> {
                    when (outputSpinner) {
                        "tablespoon" -> result = value * 0.015625
                        "quarts" -> result = value
                        "cups" -> result = value / 4
                    }
                }
            }

            return result



    }
}