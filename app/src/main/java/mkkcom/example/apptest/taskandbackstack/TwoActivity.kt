package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityTwoBinding

class TwoActivity : BaseActivity<ActivityTwoBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,  TwoActivity::class.java)
        }
    }

    override val pageTitle: String get() = "Activity Two"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTwoBinding {
       return ActivityTwoBinding.inflate(layoutInflater)
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

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "on New Intent", Toast.LENGTH_LONG).show()
    }
    private fun goOneActivity(){

        val intent= OneActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goTwoActivity(){

        val intent= getInstance(this)
        startActivity(intent)

    }
}