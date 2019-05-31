package com.tivesoft.androidktxtest

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.text.bold
import androidx.core.text.isDigitsOnly
import androidx.core.text.italic
import androidx.core.text.underline
import kotlinx.android.synthetic.main.activity_main.*

// Author: Alvaro Orellana
// https://developer.android.com/kotlin/ktx

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testTextUtil()
        testOperatorOverloading()
        testSharedPreferences()
        testText()
    }

    fun testTextUtil() {
        println("1".isDigitsOnly())
    }

    fun testOperatorOverloading() {
        var names = arrayOf("cat 1", "dog 2", "bird 3", "monkey 4")
        names.forEach { println(it) }
        val selectedName = names[1]
        names += selectedName
        names.forEach { println(it) }
    }

    fun testSharedPreferences() {
        val sharedPreferences = this.getSharedPreferences("users", Context.MODE_PRIVATE)
        //Asynchronous
        sharedPreferences.edit { putString("username", "tiveor") }
        //Synchronous
        sharedPreferences.edit(commit = true) { putString("password", "123456") }

        println(sharedPreferences!!.getString("username", "NONE"))
        println(sharedPreferences!!.getString("password", "NONE"))
    }

    fun testText() {
        val builder = SpannableStringBuilder("Hello ")
            .bold { italic { underline { append("Good Morning") } } }
        txt_hello.text = builder
    }

}