package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityTaskAndBackStackBinding
import mkkcom.example.apptest.lifecycle.LifecycleActivity

class TaskAndBackStackActivity : BaseActivity<ActivityTaskAndBackStackBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,  TaskAndBackStackActivity::class.java)
        }
    }
    override val pageTitle: String get() = "Task and Back Stack"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTaskAndBackStackBinding {
        return  ActivityTaskAndBackStackBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.buttonActivityOne.setOnClickListener {
            this.goOneActivity()

        }
        binding.buttonActivityTwo.setOnClickListener {
            this.goTwoActivity()
        }

    }

    private fun goOneActivity(){

        val intent= OneActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goTwoActivity(){

        val intent= TwoActivity.getInstance(this)
        startActivity(intent)

    }

}