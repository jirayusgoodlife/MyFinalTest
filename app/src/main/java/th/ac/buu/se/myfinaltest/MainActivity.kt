package th.ac.buu.se.myfinaltest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.ToggleButton
import android.view.LayoutInflater


class MainActivity : AppCompatActivity() {
    var COLLECTION_PRODUCT = "product"
    var COLLECTION_CART = "cart"

    var main_menu: Menu? = null;
    var isLogin = false;
    var actionbar: ActionBar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //actionbar
        actionbar = supportActionBar
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

        /** Free Code if You Can Fix Error Ahahahaha

        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user == null) {

                isLogin = false
            } else {

                isLogin = true
            }
        }


        var query: Query = mReference.child(COLLECTION_PRODUCT)
        var options = FirebaseRecyclerOptions.Builder<ProductModel>()
            .setQuery(query, ProductModel::class.java)
            .build()

        mAdapter = object : FirebaseRecyclerAdapter<ProductModel, ProductViewHolder>(options) {
            override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductViewHolder {
                val inflater = LayoutInflater.from(p0.getContext())
                return ProductViewHolder(inflater.inflate(R.layout.item_product, p0, false));

            }

            override fun onBindViewHolder(holder: ProductViewHolder, position: Int, model: ProductModel) {
                holder.show_product_name.text = model.name
                holder.show_product_price.text = "${model.price} .-"
                holder.btn_add_cart.setOnCheckedChangeListener { view, isClick ->
                    if (isClick) {
                        if (isLogin){
                            mReference.child(COLLECTION_CART).child(mAuth!!.currentUser!!.uid).push().setValue(model)
                            holder.btn_add_cart.setBackgroundDrawable(getDrawable(R.drawable.ic_star_yellow_24dp))
                            Toast.makeText(this@MainActivity, "Add to Cart", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@MainActivity, "Please Login", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        holder.btn_add_cart.setBackgroundDrawable(getDrawable(R.drawable.ic_star_border_white_24dp))
                    }
                }
            }
        }

        recyclerView.adapter = mAdapter

        */

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
        if (!isLogin) {
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
                if (isLogin) {
                    Toast.makeText(this, "Sign Out", Toast.LENGTH_SHORT).show()

                    true
                } else {
                    var intent = Intent(this, AuthActivity::class.java)
                    startActivity(intent)

                    if (!isLogin) {
                        main_menu!!.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_face_black_24dp))
                    } else {
                        main_menu!!.getItem(0)
                            .setIcon(ContextCompat.getDrawable(this, R.drawable.ic_power_settings_new_black_24dp))
                    }

                    true
                }
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var show_product_name: TextView
        var show_product_price: TextView
        var btn_add_cart: ToggleButton

        init {
            show_product_name = itemView.findViewById(R.id.show_product_name)
            show_product_price = itemView.findViewById(R.id.show_product_price)
            btn_add_cart = itemView.findViewById(R.id.btn_add_cart)
        }

    }
}
