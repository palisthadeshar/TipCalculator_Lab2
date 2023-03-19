package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private var tipAmt:Double=0.0
    private var isSwitchChecked:Boolean=true
    private var totalTip:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText:EditText = findViewById(R.id.cost_of_service)
        val radioGroup: RadioGroup = findViewById(R.id.tip_options);
        val roundTip:Switch = findViewById(R.id.round_up_switch);
        val calcTipAmount:Button = findViewById(R.id.calculate_button);
        val tipAmountText:TextView = findViewById(R.id.tip_result);



        calcTipAmount.setOnClickListener {
            val costString = editText.text.toString()
            val cost = Integer.parseInt(costString)
            when (radioGroup.checkedRadioButtonId) {
                R.id.option_eighteen_percent -> tipAmt = 0.18
                R.id.option_fifteen_percent -> tipAmt = 0.15
                R.id.option_twenty_percent -> tipAmt = 0.2
            }
            isSwitchChecked = roundTip.isChecked
            totalTip = tipAmt * cost
            if (isSwitchChecked) {
                totalTip = totalTip.roundToInt().toDouble()
            }
            tipAmountText.text = totalTip.toString()
        }

        }
    }
