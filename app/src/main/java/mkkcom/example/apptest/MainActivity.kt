package mkkcom.example.apptest

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import mkkcom.example.apptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding
   // private var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        supportActionBar?.title="Main Menu"

      //  binding.tvGreeting.text="Mingalarpar"

       /* binding.btnShowTime.setOnClickListener {
            this.count++
           this.showcount()
        }*/
        binding.btnLifecycle.setOnClickListener {
            this.goToLifecycleScreen()
        }
        binding.btnBrocast.setOnClickListener {

            this.goToBroadcastScreen()
        }

        //this.showcount()


    }
   /* private fun showcount(){
        //binding.tvGreeting.text= this.count.toString()
    }*/



    private fun goToLifecycleScreen(){
        // Toast.makeText(this,"Go To Broadcast Receiver",Toast.LENGTH_LONG).show()
        val intent=Intent(this,LifecycleActivity::class.java)
        startActivity(intent)
    }
       private fun goToBroadcastScreen(){
          // Toast.makeText(this,"Go To Broadcast Receiver",Toast.LENGTH_LONG).show()
           val intent=Intent(this,BroadcastActivity::class.java)
           startActivity(intent)
       }

     }