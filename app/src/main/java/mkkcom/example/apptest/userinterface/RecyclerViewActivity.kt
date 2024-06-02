package mkkcom.example.apptest.userinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityRecyclerViewBinding
import mkkcom.example.apptest.databinding.RecyclerViewItemBinding

class RecyclerViewActivity : BaseActivity<ActivityRecyclerViewBinding>() {

    companion object {

        fun getInstance(context: Context): Intent {
            return Intent(context, RecyclerViewActivity::class.java)

        }
    }

    override val pageTitle: String
        get() = "Recycler View"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityRecyclerViewBinding {
        return ActivityRecyclerViewBinding.inflate(layoutInflater)
    }
    private val adapter = MyAdapter()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dividerItemDecoration = DividerItemDecoration(this, RecyclerView.VERTICAL)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        ResourcesCompat.getDrawable(resources, R.drawable.divider_drawable, null)
            ?.let { drawable -> dividerItemDecoration.setDrawable(drawable) }
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.btnAnime.setOnClickListener {
            val anime = listOf("One piece","Naruto","Dragon Ball","Bleach","Hunter X Hunter","Berserk","Demon Slayer","Jujutsu Kaisen")
            adapter.item = anime
            adapter.notifyDataSetChanged()
        }
        binding.btnCountries.setOnClickListener {
            val countries = listOf("Thailand","Malaysia","Singapore","Philippines")
            adapter.item = countries
            adapter.notifyDataSetChanged()
        }

    }

    private class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
         var item = listOf<String>()
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

            return MyViewHolder(
                RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }


        override fun getItemCount(): Int {
            return item.count()
        }

        override fun onViewRecycled(holder: MyViewHolder) {
            super.onViewRecycled(holder)
            holder.clearData()
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.setUpData(item[position])
            Log.d("TAG", "onBindViewHolder: $position ")

        }

    }

    private class MyViewHolder(val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun setUpData(value: String) {

                binding.tvTitle.text = value
                binding.tvDesc.text = "Desc $value"



        }
        @SuppressLint("SetTextI18n")
        fun clearData(){
            binding.tvTitle.text = "Title "
            binding.tvDesc.text = "Desc"
        }

    }
}