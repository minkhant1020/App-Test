package mkkcom.example.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.inputmethod.InputBinding
import mkkcom.example.apptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("TAG","onCreate")
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvGreeting.text="Mingalarpar"
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG","onStart")
        binding.tvGreeting.text="Mingalarpar2"
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG","onResume")
        binding.tvGreeting.text="Mingalarpar3"
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG","onPause")
        binding.tvGreeting.text="Mingalarpar4"
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
}