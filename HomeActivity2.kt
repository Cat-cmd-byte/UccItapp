package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homelayout)

        val navController = findNavController(R.id.nav_graph_xml)
        val bottomnav = findViewById<BottomNavigationView>(R.id.botnav)
        bottomnav.setupWithNavController(navController)

        val fabEmail: FloatingActionButton = findViewById(R.id.fab_email)
        fabEmail.setOnClickListener {
            Toast.makeText(this, "FAB clicked", Toast.LENGTH_SHORT).show()

        }

        fun sendEmail() {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:hod@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
                putExtra(Intent.EXTRA_TEXT, "Body Here")
            }
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }
        }
    }
    }