package mkkcom.example.apptest.broadcast

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import mkkcom.example.apptest.databinding.ActivityBroadcastBinding

class BroadcastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBroadcastBinding

    private lateinit var timeReceiver: TickTimeReceiver

    private lateinit var customReceiver: customReceiver

    private val customActionName="customBroadcastAction"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBroadcastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title="Broadcast Receiver"

        timeReceiver= TickTimeReceiver()
        customReceiver= customReceiver()

        binding.buttonCustomBroadcast.setOnClickListener {
            val intent = Intent()
            intent.setAction(customActionName)
            sendBroadcast(intent)
        }



    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    override fun onResume() {
        super.onResume()
        val filter: IntentFilter=IntentFilter().also {
            it.addAction(Intent.ACTION_TIME_TICK)
        }
        registerReceiver(timeReceiver,filter)

        val customFilter: IntentFilter=IntentFilter().also {
            it.addAction(customActionName)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(customReceiver,customFilter, RECEIVER_NOT_EXPORTED)
        }else{
            registerReceiver(customReceiver,customFilter,)
        }
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(timeReceiver)
        unregisterReceiver(customReceiver)
    }
class AirplaneModeReceiver : BroadcastReceiver(){

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.d("TAG","AirplaneModeReceiver Received")

        intent?.let {
            Log.d("TAG","Is Airplane Mode On = ${intent.getBooleanExtra("state",false)}")
        }

    }

}

    class TickTimeReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("TAG","TickTimeReceiver received")

        }

    }

}