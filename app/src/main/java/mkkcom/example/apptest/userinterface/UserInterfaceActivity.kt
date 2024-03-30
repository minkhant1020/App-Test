package mkkcom.example.apptest.userinterface


import android.content.Context
import android.content.Intent

import android.os.Bundle
import android.view.LayoutInflater

import mkkcom.example.apptest.BaseActivity

import mkkcom.example.apptest.databinding.ActivityUserInterfaceBinding


class UserInterfaceActivity : BaseActivity<ActivityUserInterfaceBinding>() {

    companion object{




        fun getInstance(context: Context): Intent {
            return Intent(context, UserInterfaceActivity ::class.java)

        }
    }

    override val pageTitle: String get() = "User Interface"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityUserInterfaceBinding {
        return ActivityUserInterfaceBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnBasicView.setOnClickListener { this.goToBasicViewActivity() }
        binding.btnLayoutActivity.setOnClickListener { this.goToLayoutActivity() }
        binding.btnLayoutConstraintActivity.setOnClickListener { this.goToConstraintLayoutActivity() }
    }

    private fun goToBasicViewActivity(){

        val intent= BasicViewActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goToLayoutActivity(){

        val intent= LayoutActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goToConstraintLayoutActivity(){

        val intent= ConstraintLayoutActivity.getInstance(this)
        startActivity(intent)

    }



}
