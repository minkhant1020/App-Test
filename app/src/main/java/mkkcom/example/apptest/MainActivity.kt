package mkkcom.example.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import androidx.activity.addCallback
import mkkcom.example.apptest.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
    private var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Log.d("TAG","onCreate")

        binding.tvGreeting.text="Mingalarpar"

        binding.btnShowTime.setOnClickListener {
            this.count++
           this.showcount()
        }

        this.showcount()
        onBackPressedDispatcher.addCallback {
            Log.d("TAG","onBackPressedDispatcher")
            finish()
        }

    }
    private fun showcount(){
        binding.tvGreeting.text= this.count.toString()
    }


    override fun onStart() {
        super.onStart()
        Log.d("TAG","onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG","onPause")
       
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG","onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG","onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG","onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("TAG","onSaveInstanceState")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("TAG"," onRestoreInstanceState")
    }


}