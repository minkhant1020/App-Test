package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivitySevenBinding

class SevenActivity : BaseTaskAndBackstackActivity<ActivitySevenBinding>() {

    companion object{

        private const val VALUE_ONE="value_one"
        private const val VALUE_TWO="value_two"
        fun getInstance(context: Context,valueOne: Int,valeTwo :Int): Intent {
            return Intent(context, SevenActivity::class.java).also {
                it.putExtra(VALUE_ONE,valueOne)
                it.putExtra(VALUE_TWO,valeTwo)
            }

        }
    }

    override val pageTitle: String get() = "Activity Seven"
    private  val pageSubTitle: String get() = "Choose operation"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySevenBinding {
       return ActivitySevenBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val valueOne = intent.getIntExtra(VALUE_ONE,0)
       val valeTwo = intent.getIntExtra(VALUE_TWO,0)
        supportActionBar?.subtitle=pageSubTitle

        binding.btnPlus.setOnClickListener { showResult(valueOne + valeTwo) }
        binding.btnMinus.setOnClickListener { showResult(valueOne - valeTwo) }
        binding.btnMultiply.setOnClickListener { showResult(valueOne * valeTwo) }
        binding.btnDivision.setOnClickListener { showResult(valueOne / valeTwo) }

    }
    private fun showResult(result: Int){
        val intent=EightActivity.getInstance(this, result )
        startActivity(intent)

    }
}