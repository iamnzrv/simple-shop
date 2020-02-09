package com.keksec.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.keksec.coderswag.Adapters.ProductsAdapter
import com.keksec.coderswag.R
import com.keksec.coderswag.Services.DataService
import com.keksec.coderswag.Utilities.EXTRA_CATEGORY
import com.keksec.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType)) { product ->
            val productDescriptionIntent = Intent(this, ProductDescriptionActivity::class.java)
            productDescriptionIntent.putExtra(EXTRA_PRODUCT, product.title)
            startActivity(productDescriptionIntent)
        }

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
