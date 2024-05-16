package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityTabBinding
import mkkcom.example.apptest.userinterface.fragments.HomeFragment
import mkkcom.example.apptest.userinterface.fragments.VideoFragment

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
        binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
        binding.tabLayout.selectTab(binding.tabLayout.getTabAt(0))

    }
    private val homeFragment : HomeFragment by lazy { HomeFragment() }
    private val videoFragment : VideoFragment by lazy { VideoFragment() }
    private val notificationFragment : NotificationFragment by lazy { NotificationFragment() }
    private val tabSelectedListener by lazy {
        object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.d("TAG", "onTabSelected: ")

                p0?.let {
                    when(it.position){
                        0 -> showFragment(homeFragment)

                        1 -> showFragment(videoFragment)

                        2 -> showFragment(notificationFragment)

                    }
                }

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

                p0?.let {
                    when(it.position){
                        0 -> hideFragment(homeFragment)

                        1 -> hideFragment(videoFragment)

                        2 -> hideFragment(notificationFragment)

                    }
                }

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("TAG", "onTabReselected: ")
            }

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
}