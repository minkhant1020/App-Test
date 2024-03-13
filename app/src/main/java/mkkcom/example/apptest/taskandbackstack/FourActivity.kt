package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityFourBinding

class FourActivity : BaseTaskAndBackstackActivity<ActivityFourBinding>(){

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, FourActivity::class.java)
        }
    }
    override val pageTitle: String get() = "Activity Four"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityFourBinding {
        return ActivityFourBinding.inflate(layoutInflater)
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