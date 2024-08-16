package mkkcom.example.apptest.database

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout
import androidx.appcompat.widget.PopupMenu
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.database.entity.Product
import mkkcom.example.apptest.database.entity.ProductSS
import mkkcom.example.apptest.databinding.ActivityDataBaseSsactivityBinding
import mkkcom.example.apptest.databinding.ProductItemSSBinding
import mkkcom.example.apptest.helper.MyApp
import mkkcom.example.apptest.helper.ScreenAnimation
import mkkcom.example.apptest.helper.showDialogFragment
import mkkcom.example.apptest.helper.showToast
import mkkcom.example.apptest.userinterface.fragments.AddProductFragment
import mkkcom.example.apptest.userinterface.fragments.AddProductSSFragment
import kotlin.coroutines.coroutineContext

class DataBaseSSActivity : BaseActivity<ActivityDataBaseSsactivityBinding>() {
    private val db by lazy { (application as MyApp).db }

     private val adapter = MyAdapter(this::onClickEdit, this::onClickDelete)


    companion object {


        fun getInstance(context: Context): Intent {
            return Intent(context, DataBaseSSActivity::class.java)
        }
    }

    override val pageTitle: String
        get() = "Database S S"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDataBaseSsactivityBinding {
        return ActivityDataBaseSsactivityBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.setupUI()
        this.getProducts()
    }
    private fun setupUI() {
        binding.rvProductSS.adapter = adapter
        binding.rvProductSS.layoutManager = LinearLayoutManager(this)
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
            val products = this.db.productDao().getAllProduct()
            runOnUiThread {

                adapter.setNewData(products)
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun deleteProduct(product: Product) {
        AsyncTask.execute {
            this.db.productDao().delete(product)
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
        showDialogFragment(
            AddProductSSFragment.getInstance(product),
            animation = ScreenAnimation.ENTER_UP_EXIT_STAY
        )


    }

    private fun onClickDelete(product: Product) {
        this.deleteProduct(product)

    }


    private class MyAdapter(
        private val onClickEdit: (Product) -> Unit,
        private val onClickDelete: (Product) -> Unit
    ) : RecyclerView.Adapter<MyViewHolder>() {

        //binding.btnInsertProduct.setOnClickListener { this.addProduct() }
        private var items = arrayListOf<Product>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(
                ProductItemSSBinding.inflate(LayoutInflater.from(parent.context), parent, false),
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
            Log.d("TAG", "onBindViewHolder: $position")
        }
        @SuppressLint("NotifyDataSetChanged")
        fun setNewData(product: List<Product>){
            items.clear()
            items.addAll(product)
            notifyDataSetChanged()

        }

        fun addItem(product: Product){
            items.add(product)
            notifyItemInserted(items.lastIndex)
        }
        fun removeItem(product: Product){
            val position = items.indexOf(product)
            items.remove(product)
           notifyItemRemoved(position)
        }
        fun updateItem(product: Product){
            val position = items.indexOf(product)
            items[position] = product
            notifyItemChanged(position)
        }



    }


    private class MyViewHolder(
        val binding: ProductItemSSBinding,
        private val onClickEdit: (Product) -> Unit,
        private val onClickDelete: (Product) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {



        @SuppressLint("SetTextI18n")
        fun setupData(product: Product) {
            binding.tvTitleSS.text = product.name
            binding.tvDecSS.text = product.description
            binding.tvPriceSS.text = "${product.price} MMK"
           


            itemView.setOnLongClickListener {
                // to do
                val popUpMenu = PopupMenu(itemView.context,binding.tvTitleSS,Gravity.END)
                popUpMenu.inflate(R.menu.database_menu)
                popUpMenu.setOnMenuItemClickListener {
                    when(it.itemId){
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
                        R.id.edit -> {

                            onClickEdit.invoke(product)


                            /* val title = itemView.findViewById<EditText>(R.id.tv_title_s_s)
                             val dec = itemView.findViewById<EditText>(R.id.tv_dec_s_s)*/

                            true
                        }
                        else -> false
                    }
                }
                popUpMenu.show()


                true
            }

        }

        @SuppressLint("SetTextI18n")
        fun clearData() {
            binding.tvTitleSS.text = "Product Name"
            binding.tvDecSS.text = "Description"
            binding.tvPriceSS.text = "0 MMK"

        }




    }
}
