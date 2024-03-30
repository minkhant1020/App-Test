package mkkcom.example.apptest.taskandbackstack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivitySixBinding

class SixActivity : BaseTaskAndBackstackActivity<ActivitySixBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, SixActivity::class.java)
        }
    }

    override val pageTitle: String get() = "Activity Six"
    private  val pageSubTitle: String get() = "Enter number to operate"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySixBinding {
       return ActivitySixBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnNext.setOnClickListener {
            this.goToChooseOperation()
        }
        supportActionBar?.subtitle=pageSubTitle

    }
    private fun goToChooseOperation(){
        val valueOne=binding.edtOne.text.toString().toIntOrNull()
        val valueTwo=binding.edtTwo.text.toString().toIntOrNull()
        if (valueOne != null && valueTwo != null){
            val intent=SevenActivity.getInstance(this, valueOne ,valueTwo)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Invalid Value", Toast.LENGTH_LONG).show()
        }
        
    }
}