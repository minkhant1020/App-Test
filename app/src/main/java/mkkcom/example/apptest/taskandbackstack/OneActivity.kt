package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityOneBinding

class OneActivity : BaseTaskAndBackstackActivity<ActivityOneBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,  OneActivity::class.java)
        }
    }

    override val pageTitle: String get() = "Activity One"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityOneBinding {
        return ActivityOneBinding.inflate(layoutInflater)
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