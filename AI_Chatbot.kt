package com.example.madprojectassign3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class AI_Chatbot : AppCompatActivity() {

    private val conversationHistory = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ai_chatbot)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val eTPrompt = findViewById<EditText>(R.id.eTPrompt)
        val btnSubmit = findViewById<ImageView>(R.id.btnSubmit)
        val tVResult = findViewById<TextView>(R.id.tVResult)
        btnSubmit.setOnClickListener {
            val prompt = eTPrompt.text.toString()
            conversationHistory.append("User: $prompt\n")
            val generativeModel = GenerativeModel(
                modelName = "gemini-1.5-flash",
                apiKey = "AIzaSyCcGDLLah6CLLVIRt-eVXd5BeibF8CLqDk "
            )
            runBlocking {
                val response = generativeModel.generateContent(conversationHistory.toString())
                conversationHistory.append("AI: ${response.text}\n")
                tVResult.text = response.text
            }
            eTPrompt.setText("")
        }
    }
}
