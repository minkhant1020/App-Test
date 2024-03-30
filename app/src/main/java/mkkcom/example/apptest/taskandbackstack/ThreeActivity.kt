package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityThreeBinding

class ThreeActivity :BaseTaskAndBackstackActivity<ActivityThreeBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,  ThreeActivity::class.java)
        }
    }

    override val pageTitle: String get() = "Activity Three"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityThreeBinding {
        return ActivityThreeBinding.inflate(layoutInflater)
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