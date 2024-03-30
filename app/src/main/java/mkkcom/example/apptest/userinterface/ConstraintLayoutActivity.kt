package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : BaseActivity<ActivityConstraintLayoutBinding>() {

    companion object{




        fun getInstance(context: Context): Intent {
            return Intent(context, ConstraintLayoutActivity::class.java)

        }
    }

    override val pageTitle: String get() = "Constraint Layout"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityConstraintLayoutBinding {
        return ActivityConstraintLayoutBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var animated = false
        val constraint1=ConstraintSet()
        constraint1.clone(binding.mainFrame)

        val constraint2 = ConstraintSet()
        constraint2.clone(this,R.layout.animation_final_layout)

        binding.btnAnimate.setOnClickListener {
           TransitionManager.beginDelayedTransition(binding.mainFrame)
            val constraint = if(animated) constraint1 else constraint2
            constraint.applyTo(binding.mainFrame)
            animated = !animated
        }

    }
}