package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityFiveBinding

class FiveActivity : BaseTaskAndBackstackActivity<ActivityFiveBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,  FiveActivity::class.java)
        }
    }
    override val pageTitle: String
        get() = "Activity Five"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityFiveBinding {
        return ActivityFiveBinding.inflate(layoutInflater)
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
            menu.buttonActivitySix,
        )


    }
}