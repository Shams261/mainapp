package com.example.mainapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerApps: Spinner
    private lateinit var btnLaunch: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerApps = findViewById(R.id.spinnerApps)
        btnLaunch = findViewById(R.id.btnLaunch)

        btnLaunch.setOnClickListener {
            val selectedApp = spinnerApps.selectedItem.toString()
            when (selectedApp) {
                "Calculator" -> {
                    val intent = Intent(this, CalculatorActivity::class.java)
                    intent.putExtra("input1", "5")
                    intent.putExtra("input2", "3")
                    startActivity(intent)
                }
                "Todo List" -> {
                    val intent = Intent(this, TodoListActivity::class.java)
                    intent.putExtra("task", "Buy groceries")
                    intent.putExtra("priority", "High")
                    startActivity(intent)
                }
            }
        }

        spinnerApps.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Do nothing for now
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}
