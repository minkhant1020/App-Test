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
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigator
import androidx.recyclerview.widget.GridLayoutManager
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityGridViewBinding
import mkkcom.example.apptest.databinding.AnimationFinalLayoutBinding
import mkkcom.example.apptest.databinding.GridViewItemBinding
import mkkcom.example.apptest.databinding.ListviewItemBinding
import mkkcom.example.apptest.helper.showToast
import java.util.jar.Attributes.Name

class GridViewActivity : BaseActivity<ActivityGridViewBinding>() {
    private var gridView: GridView? = null
    private var arrayList: ArrayList<AnimationFinalLayoutBinding>? = null
    private var animeLogoItem: ActivityGridViewBinding? = null
    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, GridViewActivity ::class.java)

        }
    }

    override val pageTitle: String
        get() = "Grid View"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityGridViewBinding {
       return ActivityGridViewBinding.inflate(layoutInflater)
    }
    private lateinit var  photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        //initiate the grid  view
        //in this case I make row grid in a row
        //if you want to change that change the number

        binding.recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        photoAdapter = PhotoAdapter(applicationContext)
        binding.recyclerView.adapter = photoAdapter

        //add data
        dataList.add(DataModel("Title","Desc",R.drawable.berserk))
        dataList.add(DataModel("Title","Desc",R.drawable.dragon_ball))
        dataList.add(DataModel("Title","Desc",R.drawable.naruto))
        dataList.add(DataModel("Title","Desc",R.drawable.blech))
        dataList.add(DataModel("Title","Desc",R.drawable.hunter_x_hunter))
        dataList.add(DataModel("Title","Desc",R.drawable.demon_slayer))
        dataList.add(DataModel("Title","Desc",R.drawable.jujutsu_kaisen))



        photoAdapter.setDataList(dataList)


    }

}