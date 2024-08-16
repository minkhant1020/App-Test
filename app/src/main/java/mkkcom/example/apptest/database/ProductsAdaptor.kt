package mkkcom.example.apptest.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mkkcom.example.apptest.R
import mkkcom.example.apptest.database.entity.ProductSS
import java.util.ArrayList

class ProductsAdaptor(private val listener: IAdaptor) : RecyclerView.Adapter<ProductsAdaptor.ProductViewHolder>() {

    private val allProductSS = ArrayList<ProductSS>()
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewTitle : TextView = itemView.findViewById(R.id.tv_title)
        val textViewDec : TextView = itemView.findViewById(R.id.tv_desc)
        val deleteButton : Button = itemView.findViewById(R.id.btn_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val viewHolder = ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_product,parent,false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onProductClick(allProductSS[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allProductSS.size

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = allProductSS[position]
        holder.textViewTitle.text = currentItem.toString()
        holder.textViewDec.text = currentItem.toString()
    }

    fun updateData(newData : List<ProductSS>){
        allProductSS.addAll(newData)

    }


}

interface IAdaptor{
    fun onProductClick(productSS: ProductSS)
}
