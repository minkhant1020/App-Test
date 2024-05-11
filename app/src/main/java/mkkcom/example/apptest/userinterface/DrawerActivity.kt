package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.math.MathUtils
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.google.android.material.navigation.NavigationView
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R

import mkkcom.example.apptest.databinding.ActivityDrawerBinding
import mkkcom.example.apptest.userinterface.fragments.AboutUsFragment
import mkkcom.example.apptest.userinterface.fragments.AllEmailFragment
import mkkcom.example.apptest.userinterface.fragments.DraftFragment
import mkkcom.example.apptest.userinterface.fragments.InBoxFragment
import mkkcom.example.apptest.userinterface.fragments.MenuFragment
import mkkcom.example.apptest.userinterface.fragments.SentFragment
import mkkcom.example.apptest.userinterface.fragments.SettingsFragment
import mkkcom.example.apptest.userinterface.fragments.SpamFragment
import mkkcom.example.apptest.userinterface.fragments.SupportFragment
import mkkcom.example.apptest.userinterface.fragments.TrashFragment

class DrawerActivity : BaseActivity<ActivityDrawerBinding>() {

    companion object {


        fun getInstance(context: Context): Intent {
            return Intent(context, DrawerActivity::class.java)

        }
    }


    private lateinit var drawerLayout: DrawerLayout


    override val pageTitle: String get() = "Drawer Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDrawerBinding {
        return ActivityDrawerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnOpen.setOnClickListener {
            binding.drawerLayout.open()




        }


        binding.navigationView.setNavigationItemSelectedListener {

            it.setChecked(false)
            when (it.itemId) {
                R.id.all_mail -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, AllEmailFragment.getInstance()).commit()

                R.id.inbox -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, InBoxFragment.getInstance()).commit()

                R.id.sent -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, SentFragment.getInstance()).commit()

                R.id.draft ->  supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, DraftFragment.getInstance()).commit()

                R.id.spam ->  supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, SpamFragment.getInstance()).commit()

                R.id.trash ->  supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, TrashFragment.getInstance()).commit()

                R.id.settings -> supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, SettingsFragment.getInstance()).commit()

                R.id.support ->  supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, SupportFragment.getInstance()).commit()

                R.id.about_us ->  supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_fragment, AboutUsFragment.getInstance()).commit()


            }
            binding.drawerLayout.close()

            true


        }

    }


    override fun getOnBackInvokedDispatcher(): OnBackInvokedDispatcher {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
        return super.getOnBackInvokedDispatcher()


    }
    }














