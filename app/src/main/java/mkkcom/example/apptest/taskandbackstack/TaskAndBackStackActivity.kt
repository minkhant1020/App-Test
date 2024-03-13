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

class TaskAndBackStackActivity :BaseTaskAndBackstackActivity<ActivityTaskAndBackStackBinding>() {

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
        val menu= binding.menuLayout

        this.listenButtonClick(
            menu.buttonActivityOne,
            menu.buttonActivityTwo,
            menu.buttonActivityThree,
            menu.buttonActivityFour,
            menu.buttonActivityFive,
        )

    }


}