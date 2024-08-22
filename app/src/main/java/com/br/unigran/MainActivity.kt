package com.br.unigran

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private double firstNum = 0.0;
    private String  = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val num0 : Button = findViewById (R.id.num0);
        val num1 : Button = findViewById (R.id.num1);
        val num2 : Button = findViewById (R.id.num2);
        val num3 : Button = findViewById (R.id.num3);
        val num4 : Button = findViewById (R.id.num4);
        val num5 : Button = findViewById (R.id.num5);
        val num6 : Button = findViewById (R.id.num6);
        val num7 : Button = findViewById (R.id.num7);
        val num8 : Button = findViewById (R.id.num8);
        val num9 : Button = findViewById (R.id.num9);

        val on : Button = findViewById (R.id.on);
        val off : Button = findViewById (R.id.off);
        val ac : Button = findViewById (R.id.ac);
        val del : Button = findViewById (R.id.del);
        val div : Button = findViewById (R.id.div);
        val times : Button = findViewById (R.id.times);
        val min : Button = findViewById (R.id.min);
        val equal : Button = findViewById (R.id.equal);
        val plus : Button = findViewById (R.id.plus);
        val point : Button = findViewById (R.id.point);

        val screen : TextView = findViewById(R.id.screen);

        ac.setOnClickListener {
            firstNum = 0.0
            screen.text = "0"
        }

        off.setOnClickListener {
            screen.visibility = View.GONE
        }

        on.setOnClickListener {
            screen.visibility = View.VISIBLE
            screen.text = "0"
        }

        val nums = arrayListOf(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9)

        for (num in nums) {
            num.setOnClickListener {
                val currentText = screen.text.toString()
                if (currentText != "0") {
                    screen.text = currentText + num.text
                } else {
                    screen.text = num.text
                }
            }
        }

        val opers = arrayListOf(div, times, plus, min)

        for (oper in opers) {
            oper.setOnClickListener {
                firstNum = screen.text.toString().toDouble()
                operation = oper.text.toString()
                screen.text = "0"
            }
        }

        del.setOnClickListener {
            val num = screen.text.toString()
            if (num.length > 1) {
                screen.text = num.substring(0, num.length - 1)
            } else if (num.length == 1 && num != "0") {
                screen.text = "0"
            }
        }

        point.setOnClickListener {
            if (!screen.text.toString().contains(".")) {
                screen.text = screen.text.toString() + "."
            }
        }

        equal.setOnClickListener {
            val secondNum = screen.text.toString().toDouble()
            val result: Double = when (operation) {
                "/" -> firstNum / secondNum
                "X" -> firstNum * secondNum
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                else -> firstNum + secondNum
            }
            screen.text = result.toString()
            firstNum = result
        }
    }
}