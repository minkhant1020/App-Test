package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityTabBinding
import mkkcom.example.apptest.userinterface.fragments.ChildFragment
import mkkcom.example.apptest.userinterface.tag.ActionFragment
import mkkcom.example.apptest.userinterface.tag.ComedyFragment
import mkkcom.example.apptest.userinterface.tag.DramaFragment
import mkkcom.example.apptest.userinterface.tag.HomeFragment
import mkkcom.example.apptest.userinterface.tag.HorrorFragment
import mkkcom.example.apptest.userinterface.tag.NotificationFragment
import mkkcom.example.apptest.userinterface.tag.ScifiFragment
import mkkcom.example.apptest.userinterface.tag.VideoFragment

class TabActivity : BaseActivity<ActivityTabBinding>() {
    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, TabActivity ::class.java)

        }
    }
    override val pageTitle: String get() = "Tab bar"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTabBinding {
        return ActivityTabBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        this.setupTab()
    }
    private val homeFragment : HomeFragment by lazy { HomeFragment() }
    private val videoFragment : VideoFragment by lazy { VideoFragment() }
    private val notificationFragment : NotificationFragment by lazy { NotificationFragment() }

    private fun setupTab(){
        Tab.entries.forEach {
            val tabItem = binding.tabLayout.newTab()
            tabItem.tag = it
            tabItem.text = getString(it.title)
            tabItem.icon = AppCompatResources.getDrawable(this,it.icon)
            binding.tabLayout.addTab(tabItem)
        }
        binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
        selectedTab = Tab.entries.get(binding.tabLayout.selectedTabPosition)

    }

    private val tabSelectedListener by lazy {
        object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.d("TAG", "onTabSelected: ")

                p0?.let {
                    selectedTab = it.tag as Tab
                }


            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {


            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("TAG", "onTabReselected: ")
                supportFragmentManager.popBackStack(
                    ChildFragment::class.java.name,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }

        }

    }

    private var selectedTab: Tab? = null
        set(value) {

            if (value==field || value == null) return
            field?.let { hideFragment(getFragmentByTab(it)) }
            showFragment(getFragmentByTab(value))
            Log.d("TAG", "Set selectedTab: $value ")
            field = value

        }

        get() {
            Log.d("TAG", "Get selectedTab: $field ")
            return field
        }

    private fun getFragmentByTab (tab: Tab): Fragment{
        return when (tab){
            Tab.HOME -> homeFragment
            Tab.VIDEO -> videoFragment
            Tab.NOTIFICATION -> notificationFragment

        }
    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .show(it)
                .commit()

        } ?: run {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(fragment.javaClass.name)
                .add(R.id.container,fragment,fragment.javaClass.name)
                .commit()
        }
    }
    private fun  hideFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .hide(it)
                .commit()
        }
    }

    private enum class Tab (var title: Int,var icon: Int) {

        HOME (R.string.menu_home,R.drawable.ic_home),
        VIDEO (R.string.menu_video,R.drawable.ic_video),
        NOTIFICATION (R.string.menu_notification,R.drawable.ic_notification)

    }
}