package mkkcom.example.apptest.database

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import mkkcom.example.apptest.R
import mkkcom.example.apptest.database.entity.ProductSS
import mkkcom.example.apptest.userinterface.DrawerActivity
import kotlin.random.Random

class AddProductActivity : AppCompatActivity() {
    companion object {


        fun getInstance(context: Context): Intent {
            return Intent(context, AddProductActivity::class.java)

        }
    }
    private lateinit var viewModel: ProductViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)
        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val btn : Button = findViewById(R.id.btn_insect_product)
        btn.setOnClickListener {
            addingProduct()
        }
    }
    private fun addingProduct(){
        val editTextName : EditText = findViewById(R.id.edt_product_name)
        val productName = editTextName.text.toString()
        val editTextDec : EditText = findViewById(R.id.edt_product_dec)
        val productDec = editTextDec.text.toString()
        val price = Random.nextInt(500,1000).toDouble()
        val brand = "My Brand"

        if ((productName.isNotEmpty())&&(productDec.isNotEmpty())){
            viewModel.insertProduct(ProductSS(1,productName,productDec,price,brand))
    
            val intent = Intent(this,DataBaseSSActivity::class.java)
            startActivity(intent)
        }

    }
}