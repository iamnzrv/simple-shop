package com.keksec.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.keksec.coderswag.Adapters.ProductsAdapter
import com.keksec.coderswag.R
import com.keksec.coderswag.Services.DataService
import com.keksec.coderswag.Utilities.EXTRA_CATEGORY
import com.keksec.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_desctiption.*
import kotlinx.android.synthetic.main.activity_products.*

class ProductDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_desctiption)

        val productTitle = intent.getStringExtra(EXTRA_PRODUCT)
        val product = DataService.getProduct(productTitle)
        val resourceId = this.resources.getIdentifier(product.image, "drawable", this.packageName)
        productPreviewImage.setImageResource(resourceId)
        productPreviewTitle.text = product.title
        productPreviewDescription.text = product.desc
    }
}