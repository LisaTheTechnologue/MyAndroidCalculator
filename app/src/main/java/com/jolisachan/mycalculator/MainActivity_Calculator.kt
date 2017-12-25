package com.jolisachan.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main__calculator.*
//import sun.security.util.Length
import kotlin.math.sqrt


class MainActivity_Calculator : AppCompatActivity() {

    protected var screenValue:String=calcScreen.text.toString()
    protected var factor1:Double=0.0
    protected var factor2:Double=0.0
    protected var result:String=""
    var operation:Char = 'O'
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__calculator)
    }

    fun btnNo_Click(view: View){
        val btnSelected=view as Button
        
        when(btnSelected.id){
            btn1.id->{ screenValue+="1"}
            btn2.id->{ screenValue+="2"}
            btn3.id->{ screenValue+="3"}
            btn4.id->{ screenValue+="4"}
            btn5.id->{ screenValue+="5"}
            btn6.id->{ screenValue+="6"}
            btn7.id->{ screenValue+="7"}
            btn8.id->{ screenValue+="8"}
            btn9.id->{ screenValue+="9"}
            btn.id->{ screenValue+="0"}
            btnDot.id->{
            //TODO: Prevent adding more than one dot
                screenValue+="."
            }
            btnPlusMinus.id->{
                if (screenValue == "")
                {
                    screenValue = "-"
                }
                else if (screenValue.toInt() > 0)
                {
                    screenValue = "-" + screenValue
                }
                else if (screenValue.toInt() < 0)
                {
                    screenValue = screenValue.substring(1)
                }
            }
        }
        calcScreen.setText(screenValue)
    }

    fun BtnSqrt_Click(view:View) {
        screenValue = sqrt(screenValue.toDouble()).toString()
    }

     fun BtnSqr_Click(view:View) {
        screenValue = (screenValue.toDouble() * screenValue.toDouble()).toString()
    }

     fun BtnOnePer_Click(view:View) {
        screenValue = (1.0 / screenValue.toDouble()).toString()
    }

     fun btnOperation_Click(view:View) {
        val btnOperation = view as Button

        factor1 = screenValue.toDouble()
        when (btnOperation.id) {
            btnDiv.id -> {
                operation = '/'
                screenValue = ""
            }
            btnMulti.id -> {
                operation = '*'
                screenValue = ""
            }
            btnSub.id -> {
                if (screenValue === "") {
                    screenValue = "-"
                } else {
                    operation = '-'
                    screenValue = ""
                }
            }
            btnAdd.id -> {
                operation = '+'
                screenValue = ""
            }
        }
    }

     fun btnDel_Click(view:View) {
        val TxtShown = screenValue
        val arrChar = screenValue.toCharArray()
        screenValue = ""
        for (count in 0 until TxtShown.length) {
            screenValue += arrChar[count]
        }
    }

     fun btnEqual_Click(view:View) {
        factor2 = screenValue.toDouble()

        val fcr1 = factor1.toDouble()
        val fcr2 = factor2.toDouble()

        when (operation) {
            '+' -> result = (fcr1 + fcr2).toString()

            '-' -> result = (fcr1 - fcr2).toString()

            '*' -> result = (fcr1 * fcr2).toString()

            '/' -> if (fcr2 != 0.0) {
                result = (fcr1 / fcr2).toString()
            } else {

            }
        }

        screenValue = result
    }


     fun click_Shown(view:View) {
        if (screenValue === "0.") {
            screenValue = ""
        }
        try {
            val btnNum = view as Button

            if (btnNum.text.toString().toDouble() / 1 === btnNum.text.toString().toDouble()) {
                val num = btnNum.text
                screenValue += num
            }
        } catch (ex: Exception) {
            //MessageBox.Show("Sorry for the inconvenience, Unexpected error occured. Details: " + ex.Message)
        }
    }

    fun btnC_Click(view:View){}

    fun btnBrackets_Click(view: View){

    }

    fun btnPercent_Click(view:View){}
}
