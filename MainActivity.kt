package br.iesb.mobile.nutricaopdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.nutricaopdm.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_mainscreen_signin.setOnClickListener {
            signin()
        }

        bt_mainscreen_signup.setOnClickListener {
            signup()
        }
    }

    private fun signin(){
        var email = et_mainscreen_email.text.toString()

        var password = et_mainscreen_password.text.toString()

        var auth = FirebaseAuth.getInstance()

        var authTaskSignin = auth.signInWithEmailAndPassword(email, password)

        authTaskSignin.addOnCompleteListener{response ->
            if(response.isSuccessful){
                var newActivity = Intent(this, Home::class.java)
                startActivity(newActivity)
                finish()
            }else{
                Toast.makeText(this, "Error in signin.", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun signup(){
        var newActivity = Intent(this, Signup::class.java)
        startActivity(newActivity)
        finish()
    }

}