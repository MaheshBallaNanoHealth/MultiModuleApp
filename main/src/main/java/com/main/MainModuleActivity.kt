package com.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dietitian.DietitianActivity
import com.docotor.DoctorActivity

class MainModuleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_module)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun launchDoctorModule(view: View) {
        startActivity(Intent(this, DoctorActivity::class.java))
    }

    fun launchDietitianModule(view: View) {
        try {
            startActivity(Intent(this, DietitianActivity::class.java))
        } catch (e: NoClassDefFoundError) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}