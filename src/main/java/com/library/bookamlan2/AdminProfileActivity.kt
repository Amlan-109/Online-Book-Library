package com.library.bookamlan2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import android.view.View
import android.content.Intent

class AdminProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_profile)

        // Assuming you have a function to fetch admin information
        val admin = fetchAdminInformation()

        // Populate UI elements with admin information
        val nameTextView = findViewById<TextView>(R.id.nameTextView)
        val emailTextView = findViewById<TextView>(R.id.emailTextView)
        val returnDateTextView = findViewById<TextView>(R.id.returnDateTextView)

        nameTextView.text = "Name: ${admin.name}"
        emailTextView.text = "Email: ${admin.email}"

        // Calculate return date (two weeks from the current date)
        val currentDate = Calendar.getInstance()
        val returnDate = currentDate.clone() as Calendar
        returnDate.add(Calendar.WEEK_OF_YEAR, 2)
        val dateFormat = SimpleDateFormat("MM/dd/yyyy")
        returnDateTextView.text = "Return Date: ${dateFormat.format(returnDate.time)}"
    }
    fun onNextPageButtonClick(view: View) {
        // Handle the button click event
        // Navigate to the next page
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    // Function to fetch admin information (replace with your own logic)
    private fun fetchAdminInformation(): Admin {
        // Replace this with your logic to fetch admin information
        // For example, retrieve admin details from a database or a data source
        return Admin("Admin Name", "admin@example.com")
    }
}

data class Admin(val name: String, val email: String)

