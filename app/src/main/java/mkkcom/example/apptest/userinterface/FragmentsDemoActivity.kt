package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.databinding.ActivityFragmentsDemoBinding

class FragmentsDemoActivity : BaseActivity<ActivityFragmentsDemoBinding>() {


    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,FragmentsDemoActivity ::class.java)

        }
    }
    override val pageTitle: String get() = "Fragments"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityFragmentsDemoBinding {
       return ActivityFragmentsDemoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)







    }
}