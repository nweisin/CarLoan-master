package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            calculate(it)
        }
    }

    private fun calculate(view: View) {
        var carPrice = findViewById<EditText>(R.id.carPrice).text.toString()
        var downPayment = findViewById<EditText>(R.id.PaymentAmount).text.toString()
        var loanPeriod = findViewById<EditText>(R.id.loanPeriod).text.toString()
        var interestRate = findViewById<EditText>(R.id.Interest).text.toString()

        var carLoan:Double = carPrice.toDouble() - downPayment.toDouble()
        var interest:Double = carLoan.toDouble() * (interestRate.toDouble()/100) * loanPeriod.toDouble()
        var monthlyPay:Double = (carLoan.toDouble() + interest.toDouble()) / loanPeriod.toDouble() / 12

        result.visibility = View.VISIBLE
        result_car_price.visibility = View.VISIBLE
        result_interest.visibility = View.VISIBLE
        result_monthly.visibility = View.VISIBLE

        result_car_price.text = "Car Loan : $carLoan"
        result_interest.text = "Interest : $interest"
        result_monthly.text = "Monthly Payment : %.2f".format(monthlyPay)

    }
}
