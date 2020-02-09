package com.example.calculator_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var operation = ""
    var oldValue = ""
    var isNewValue = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display.setText("0")
    }

    fun btnEvent(view: View) {
        if (isNewValue) {
            display.setText("")
        }
        isNewValue = false
        val selectedBtn = view as Button
        var btnValue = display.text.toString()
        when(selectedBtn.id) {
            btn0.id -> {
                btnValue += "0"
            }
            btn1.id -> {
                btnValue += "1"
            }
            btn2.id -> {
                btnValue += "2"
            }
            btn3.id -> {
                btnValue += "3"
            }
            btn4.id -> {
                btnValue += "4"
            }
            btn5.id -> {
                btnValue += "5"
            }
            btn6.id -> {
                btnValue += "6"
            }
            btn7.id -> {
                btnValue += "7"
            }
            btn8.id -> {
                btnValue += "8"
            }
            btn9.id -> {
                btnValue += "9"
            }
            btnDot.id -> {
                //TODO:duplicates not allowed
                btnValue += "."
            }

            btnMinusPlus.id -> {
                btnValue = "-" + btnValue
            }
        }

        display.setText(btnValue)
    }

    fun operationEvent(view: View) {
        var selectedBtn = view as Button
        when(selectedBtn.id) {
            btnMinus.id -> {
                operation = "-"
            }

            btnAdd.id -> {
                operation = "+"
            }

            btnMul.id -> {
                operation = "*"
            }

            btnDiv.id -> {
                operation = "/"
            }
        }
        oldValue = display.text.toString()
        isNewValue = true
    }

    fun equalEvent(view: View) {
        var newValue = display.text.toString()
        var result:Double? = null
        when(operation) {
            "-" -> {
                result = oldValue.toDouble() - newValue.toDouble()
            }

            "+" -> {
                result = oldValue.toDouble() + newValue.toDouble()
            }

            "/" -> {
                result = oldValue.toDouble() / newValue.toDouble()
            }

            "*" -> {
                result = oldValue.toDouble() * newValue.toDouble()
            }

            "%" -> {
                result = oldValue.toDouble() % newValue.toDouble()
            }
        }

        display.setText(result.toString())
        isNewValue = true
    }

    fun percentEvent(view: View) {
        var value = display.text.toString().toDouble() /100
        display.setText(value.toString())
        isNewValue = true
    }

    fun clearEvent(view: View) {
        display.setText("0.0")
        isNewValue = true
    }
}
