package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import com.google.android.material.tabs.TabLayoutMediator
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.databinding.ActivityTabBinding
import mkkcom.example.apptest.databinding.ActivityViewPagerTabBinding


class TabViewPagerActivity : BaseActivity<ActivityViewPagerTabBinding>() {
    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, TabViewPagerActivity ::class.java)

        }
    }
    private val TabArray = arrayOf(
        "Home",
        "Video",
        "Notification"
    )

    override val pageTitle: String get() =" Tab Bar"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityViewPagerTabBinding {
       return ActivityViewPagerTabBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = TabPageChange(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = TabArray[position]
        }.attach()
    }
    }
