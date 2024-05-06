package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivitySsimageViewBinding

class SSImageViewActivity : BaseActivity<ActivitySsimageViewBinding>() {

    val imageList= mutableListOf<Drawable?>()
    var currentIndex = 0

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, SSImageViewActivity ::class.java)

        }
    }

    override val pageTitle: String get() = "SS Image View"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySsimageViewBinding {
       return ActivitySsimageViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnChangeView.setOnClickListener {this.changePhoto() }



        imageList.add( AppCompatResources.getDrawable(this,R.drawable.luffy_gear_second))
        imageList.add(AppCompatResources.getDrawable(this,R.drawable.luffy_wanted))

    }
    private fun changePhoto(){
        val drawable =this.imageList[currentIndex]
        binding.imageViewSS.setImageDrawable(drawable)
        currentIndex++
        if (currentIndex>=imageList.size){
            currentIndex=0
        }

    }
}