package th.ac.buu.se.myfinaltest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class AuthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Auth / Register"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        // get element in layout
        var input_username = findViewById<EditText>(R.id.input_username)
        var input_password = findViewById<EditText>(R.id.input_password)
        var btn_signin = findViewById<Button>(R.id.btn_signin)
        var btn_signup = findViewById<Button>(R.id.btn_signup)

        btn_signin.setOnClickListener {

            Toast.makeText(this, "Click Sign In", Toast.LENGTH_SHORT).show()
            finish()
        }

        btn_signup.setOnClickListener {

            Toast.makeText(this, "Click Sign Up", Toast.LENGTH_SHORT).show()
            finish()
        }



    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onStop() {
        super.onStop()

    }
}
