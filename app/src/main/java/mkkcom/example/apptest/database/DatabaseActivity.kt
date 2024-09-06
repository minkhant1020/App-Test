package mkkcom.example.apptest.database

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.databinding.ActivityDatabaseBinding
import mkkcom.example.apptest.databinding.ProductItemBinding
import mkkcom.example.apptest.helper.MyApp
import mkkcom.example.apptest.helper.ScreenAnimation
import mkkcom.example.apptest.helper.showDialogFragment
import mkkcom.example.apptest.helper.showToast
import mkkcom.example.apptest.userinterface.fragments.AddProductFragment
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class DatabaseActivity : BaseActivity<ActivityDatabaseBinding>() {

    private val initDatabase : MyDatabase = get()
   // private val db by lazy { (application as MyApp).dp }
    private val adapter = MyAdapter(this::onClickEdit, this::onClickDelete)


    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, DatabaseActivity::class.java)
        }
    }
    override val pageTitle: String = "Database"
    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDatabaseBinding {
        return ActivityDatabaseBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setupUI()
        this.getProducts()
    }
    private fun setupUI() {
        binding.rvProduct.adapter = adapter
        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing = false
            this.getProducts()
        }
        binding.floatingActionButton.setOnClickListener {
            showDialogFragment(
                AddProductFragment.getInstance(),
                animation = ScreenAnimation.ENTER_UP_EXIT_STAY
            )
        }
    }

    @SuppressLint("NotifyDataSetChanged")

        private fun getProducts() {
            AsyncTask.execute {
                val products = this.initDatabase.productDao().getProductsByMaxPrice(price = 1000.0)
                runOnUiThread {

                    adapter.setNewData(products)
                    adapter.notifyDataSetChanged()
                }
            }
        }

            private fun deleteProduct(product: Product) {
                AsyncTask.execute {
                    this.initDatabase.productDao().delete(product)
                    runOnUiThread {
                        adapter.removeItem(product)
                        showToast("Product deleted")
                    }
                }
            }

            fun refreshAdapterForNewProduct(product: Product) {
                runOnUiThread {
                    adapter.addItem(product)
                    showToast("Product added")
                }
            }

            fun refreshAdapterForUpdatedProduct(product: Product) {
                runOnUiThread {
                    adapter.updateItem(product)
                    showToast("Product updated")
                }
            }

            private fun onClickEdit(product: Product) {
                showToast("Clicked Edit for ${product.name}")
                showDialogFragment(
                    AddProductFragment.getInstance(product),
                    animation = ScreenAnimation.ENTER_UP_EXIT_STAY
                )
            }

            private fun onClickDelete(product: Product) {
                showToast("Clicked Delete for ${product.name}")
                this.deleteProduct(product)
            }

            private class MyAdapter(
                private val onClickEdit: (Product) -> Unit,
                private val onClickDelete: (Product) -> Unit
            ) : RecyclerView.Adapter<MyViewHolder>() {


                private var items = arrayListOf<Product>()

                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                    return MyViewHolder(
                        ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                        onClickEdit, onClickDelete
                    )
                }
                override fun getItemCount(): Int {
                    return items.count()
                }
                override fun onViewRecycled(holder: MyViewHolder) {
                    super.onViewRecycled(holder)
                    holder.clearData()
                }
                override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                    holder.setupData(items[position])
                }

                @SuppressLint("NotifyDataSetChanged")
                fun setNewData(products: List<Product>) {
                    items.clear()
                    items.addAll(products)
                    notifyDataSetChanged()
                }

                fun addItem(product: Product) {
                    items.add(product)
                    notifyItemInserted(items.lastIndex)
                }

                fun removeItem(product: Product) {
                    val position = items.indexOf(product)
                    items.remove(product)
                    notifyItemRemoved(position)
                }

                fun updateItem(product: Product) {
                    val position = items.indexOfFirst { item ->
                        item.id == product.id
                    }
                    items[position] = product
                    notifyItemChanged(position)
                }

            }

            private class MyViewHolder(
                val binding: ProductItemBinding,
                private val onClickEdit: (Product) -> Unit,
                private val onClickDelete: (Product) -> Unit
            ) : RecyclerView.ViewHolder(binding.root) {
                @SuppressLint("SetTextI18n")
                fun setupData(product: Product) {
                    binding.tvTitle.text = product.name
                    binding.tvDec.text = product.description
                    binding.tvPrice.text = "${product.price} MMK"
                    itemView.setOnLongClickListener {
                        val menu = PopupMenu(itemView.context, binding.tvTitle, Gravity.END)
                        menu.inflate(R.menu.database_menu)
                        menu.setOnMenuItemClickListener {
                            when (it.itemId) {
                                R.id.edit -> {
                                    onClickEdit.invoke(product)
                                    true
                                }
                                R.id.delete -> {
                                    AlertDialog.Builder(itemView.context)
                                        .setTitle("Delete")

                                        .setMessage("Are you sure delete this Information")
                                        .setPositiveButton("Yes"){
                                                dialog,_->
                                            onClickDelete.invoke(product)



                                            dialog.dismiss()
                                        }
                                        .setNegativeButton("No"){
                                                dialog,_->
                                            dialog.dismiss()
                                        }
                                        .create()
                                        .show()
                                    true
                                }
                                else -> {
                                    false
                                }
                            }
                        }
                        menu.show()
                        true
                    }
                }
                @SuppressLint("SetTextI18n")
                fun clearData() {
                    binding.tvTitle.text = "Product Name"
                    binding.tvDec.text = "Description"
                    binding.tvPrice.text = "0 MMK"
                }
            }
    






}
   


    /* private fun addProduct(){
       val name = binding.edtProductName.text.toString()
       val dec = binding.edtProductDec.text.toString()
       val price = Random.nextInt(500,1000).toDouble()
       val brand = "My Brand"

       val product = Product(
           id = 0,
           name = name,
           description = dec,
           price = price,
           brand = brand,

       )
       AsyncTask.execute {
           this.db.productDao().insert(product)
           this.getProduct()

       }


       }
   private fun getProduct(){
       AsyncTask.execute {
           val products=this.db.productDao().getAllProduct()
           runOnUiThread{
               showToast("Total product count = ${products.value}")
           }
       }

   }*/




