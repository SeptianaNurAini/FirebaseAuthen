package com.septiana.firebaseauthen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFirebaseAuth()
        getData()

        btnLogout.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, AuthActivity::class.java))
        }
    }

    private fun getData() {
        val user = auth.currentUser
        if(user != null){
            val userEmail = user.email.toString()
            val getNameEmail = userEmail?.split(Regex("@gmail.com"))
            val getStringName = getNameEmail?.joinToString("")
            tvEmail.text = getStringName
        }
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }
}