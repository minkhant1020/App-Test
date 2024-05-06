package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityDrawerBinding

class DrawerActivity : BaseActivity<ActivityDrawerBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, DrawerActivity ::class.java)

        }
    }
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
            true
        }

    }
}