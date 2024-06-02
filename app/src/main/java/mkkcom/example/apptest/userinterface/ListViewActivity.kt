package mkkcom.example.apptest.userinterface

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityListViewBinding
import mkkcom.example.apptest.databinding.ListviewItemBinding
import mkkcom.example.apptest.helper.showToast

class ListViewActivity : BaseActivity<ActivityListViewBinding>() {
    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, ListViewActivity ::class.java)

        }
    }
    override val pageTitle: String get() = "List View"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityListViewBinding {
        return ActivityListViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpCustomAdapter()

    }
    private fun setupSimpleAdapter() {
        val anime =
            listOf("One piece","Naruto","Dragon Ball","Bleach","Hunter X Hunter","Berserk","Demon Slayer","Jujutsu Kaisen")
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            anime
        )
        binding.listView.adapter = adapter
    }

    private fun setUpCustomAdapter(){
        val anime = listOf(
            Pair("One piece",R.drawable.luffy_gear_second),
            Pair("Naruto",R.drawable.naruto),
            Pair("Dragon Ball",R.drawable.dragon_ball),
            Pair("Bleach",R.drawable.blech),
            Pair("Hunter X Hunter",R.drawable.hunter_x_hunter),
            Pair("Berserk",R.drawable.berserk),
            Pair("Demon Slayer",R.drawable.demon_slayer),
            Pair("Jujutsu Kaisen",R.drawable.jujutsu_kaisen)
        )
        val adapter = CustomAdapter(anime)

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            val item = adapter.getItem(position) as? Pair<*, *>
            val name = item?.first as? String ?: "Unknown"
            this@ListViewActivity.showToast(name)
        }

        binding.listView.adapter = adapter
    }

    private class CustomAdapter(val items: List<Pair<String, Int>>) : BaseAdapter() {

        override fun getCount(): Int {
            return items.count()
        }

        override fun getItem(p0: Int): Any {
            return items[p0]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        @SuppressLint("ViewHolder")
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val binding = ListviewItemBinding.inflate(LayoutInflater.from(p2?.context))
            binding.name.text = items[p0].first
            return binding.root
        }

    }
}