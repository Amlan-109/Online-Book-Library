package com.library.bookamlan2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AdminLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        val usernameInput = findViewById<EditText>(R.id.adminUsername)
        val passwordInput = findViewById<EditText>(R.id.adminPassword)
        val loginButton = findViewById<Button>(R.id.adminLoginButton)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (isValidAdminCredentials(username, password)) {
                // Successful login, navigate to the admin page.
                val intent = Intent(this, AdminProfileActivity::class.java)
                startActivity(intent)
            } else {
                // Display an error message for invalid credentials.
                // You can display a Toast or a TextView to inform the user of the error.
            }
        }
    }

    private fun isValidAdminCredentials(username: String, password: String): Boolean {

        // For example, if you have a list of admin usernames:
        val adminUsernames = listOf("admin", "superadmin","amlan122","piya123")

        if (adminUsernames.contains(username) && password == ("adminpassword")) {
            return true
        }
        // Assuming you have a data class to represent user information
        data class User(val username: String, val loginTime: Long)

        class AdminLoginActivity : AppCompatActivity() {

            // ...

            private fun onLoginButtonClicked() {
                val username = "admin" // Replace with actual admin username
                val password = "admin123" // Replace with actual admin password

                // Check admin credentials
                if (isValidAdminCredentials(username, password)) {
                    // Log successful login
                    val user = User(username, System.currentTimeMillis())
                    logSuccessfulLogin(user)
                    // Navigate to the admin dashboard or logged-in user list
                    // ...
                } else {
                    // Handle failed login
                    // ...
                }
            }

            private fun isValidAdminCredentials(username: String, password: String): Boolean {
                // Replace this with your authentication logic
                return (username == "admin" && password == "admin123")
            }

            private fun logSuccessfulLogin(user: User) {
                // Store user information in a database or log file
                // You can use SharedPreferences, Room Database, Firebase, or other storage options
                // ...
            }

            // ...
        }


        return false
    }
}
