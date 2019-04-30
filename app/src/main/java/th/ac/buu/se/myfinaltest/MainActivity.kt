package th.ac.buu.se.myfinaltest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var main_menu: Menu? = null;
    var checkLogin = false;

    var COLLECTION_PRODUCT = "product"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "My Final Test"


        // get element in layout
        var fab = findViewById<FloatingActionButton>(R.id.btn_fab_add)
        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // button add product
        fab.setOnClickListener {
            var intent = Intent(this, AddProductActivity::class.java)
            startActivity(intent)
        }

        checkLogin = true
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        main_menu = menu

        // check firebase login if login show power icon else show face icon
        if (checkLogin) {
            main_menu!!.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_face_black_24dp))
        } else {
            main_menu!!.getItem(0)
                .setIcon(ContextCompat.getDrawable(this, R.drawable.ic_power_settings_new_black_24dp))
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Handle item selection
        return when (item!!.itemId) {
            R.id.action_cart -> {
                Toast.makeText(this, "Goto Cart", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, CartActivity::class.java)
                startActivity(intent)

                true
            }
            R.id.action_login_logout -> {
                Toast.makeText(this, "Goto Login/Logout", Toast.LENGTH_SHORT).show()
                var intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)

                // check if login show this
                if (main_menu != null) {
                    main_menu!!.getItem(0)
                        .setIcon(ContextCompat.getDrawable(this, R.drawable.ic_power_settings_new_black_24dp))
                }
                // else show icon login
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
