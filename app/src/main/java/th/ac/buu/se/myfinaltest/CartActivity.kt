package th.ac.buu.se.myfinaltest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    val COLLECTION_CART = "cart"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Cart"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        // get element in layout
        var list_cart = findViewById<RecyclerView>(R.id.list_cart)
        list_cart.layoutManager = LinearLayoutManager(this)


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
