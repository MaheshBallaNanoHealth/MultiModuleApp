package com.nh_utility

import android.content.Context
import android.util.DisplayMetrics
import android.widget.Toast
import kotlin.math.pow
import kotlin.math.sqrt

object Utils {

    // Arithmetic Operations
    fun add(a: Double, b: Double): Double = a + b
    fun subtract(a: Double, b: Double): Double = a - b
    fun multiply(a: Double, b: Double): Double = a * b
    fun divide(a: Double, b: Double): Double = if (b != 0.0) a / b else Double.NaN
    fun square(a: Double): Double = a * a
    fun squareRoot(a: Double): Double = sqrt(a)
    fun power(a: Double, b: Double): Double = a.pow(b)

    // Display Metrics Calculation
    fun dpToPx(context: Context, dp: Float): Float {
        return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun pxToDp(context: Context, px: Float): Float {
        return px / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }

    fun spToPx(context: Context, sp: Float): Float {
        return sp * context.resources.displayMetrics.scaledDensity
    }

    fun pxToSp(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.scaledDensity
    }

    fun screenWidthPx(context: Context): Int {
        return context.resources.displayMetrics.widthPixels
    }

    fun screenHeightPx(context: Context): Int {
        return context.resources.displayMetrics.heightPixels
    }

    // Toast Messages
    fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, message, duration).show()
    }

    // Validation
    fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    fun isValidPhoneNumber(phone: String): Boolean {
        return phone.length == 10 && phone.all { it.isDigit() }
    }

    // Currency Formatting
    fun formatCurrency(amount: Double): String {
        return String.format("$%.2f", amount)
    }

    // Number Formatting
    fun formatDecimal(number: Double, decimalPlaces: Int): String {
        return "%.${decimalPlaces}f".format(number)
    }

    // Utility
    fun isEven(number: Int): Boolean = number % 2 == 0
    fun isOdd(number: Int): Boolean = number % 2 != 0

    // Conversions
    fun celsiusToFahrenheit(celsius: Double): Double = (celsius * 9 / 5) + 32
    fun fahrenheitToCelsius(fahrenheit: Double): Double = (fahrenheit - 32) * 5 / 9

    // Text Utilities
    fun capitalizeWords(text: String): String {
        return text.split(" ").joinToString(" ") { it.capitalize() }
    }
    
    fun reverseString(text: String): String {
        return text.reversed()
    }
}
