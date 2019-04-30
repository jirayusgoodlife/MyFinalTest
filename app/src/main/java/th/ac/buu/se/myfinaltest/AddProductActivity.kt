package th.ac.buu.se.myfinaltest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.widget.EditText
import android.widget.Toast

class AddProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Add New Product"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        // get element in layout
        var fab_save = findViewById<FloatingActionButton>(R.id.btn_fab_save)
        var input_product_name = findViewById<EditText>(R.id.input_product_name)
        var input_product_price = findViewById<EditText>(R.id.input_product_price)


        // click action on save button
        fab_save.setOnClickListener {
            // Check can insert to db
            var check_success = true

            if (check_success) {
                Toast.makeText(this, "Add Product Success", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Can't Add Product", Toast.LENGTH_SHORT).show()
            }
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
