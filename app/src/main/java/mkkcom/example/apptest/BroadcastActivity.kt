package mkkcom.example.apptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mkkcom.example.apptest.databinding.ActivityBroadcastBinding
import mkkcom.example.apptest.databinding.ActivityMainBinding

class BroadcastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBroadcastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title="Broadcast Receiver"
    }
}