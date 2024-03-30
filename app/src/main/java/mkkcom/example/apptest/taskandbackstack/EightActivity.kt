package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.addCallback
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityEightBinding

class EightActivity : BaseTaskAndBackstackActivity<ActivityEightBinding>() {

    companion object{


        private const val VALUE_RESULT="value_result"

        fun getInstance(context: Context,valueResult: Int): Intent {
            return Intent(context,EightActivity ::class.java).also {
                it.putExtra(VALUE_RESULT,valueResult)

            }

        }
    }

    override val pageTitle: String get() = "Activity Eight"
    private  val pageSubTitle: String get() = "Check the result"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityEightBinding {
        return ActivityEightBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.subtitle=pageSubTitle

        val result: Int=intent.getIntExtra(VALUE_RESULT,0)
        binding.tvResult.text=result.toString()

        binding.btnFinish.setOnClickListener {
            this.finishCaculationPages()

        }
        this.onBackPressedDispatcher.addCallback {
            finishCaculationPages()
        }

    }
    private fun finishCaculationPages(){
        finishAffinity()
    }
}