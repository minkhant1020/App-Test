package mkkcom.example.apptest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import mkkcom.example.apptest.broadcast.BroadcastActivity
import mkkcom.example.apptest.databinding.ActivityMainBinding
import mkkcom.example.apptest.lifecycle.LifecycleActivity

class MainActivity : BaseActivity< ActivityMainBinding>() {


    override val pageTitle: String get() ="Main Menu"
    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)






      //  binding.tvGreeting.text="Mingalarpar"

       /* binding.btnShowTime.setOnClickListener {
            this.count++
           this.showcount()
        }*/
        binding.btnLifecycle.setOnClickListener {
            this.goToLifecycleScreen()
        }
        binding.btnBroadcast.setOnClickListener {

            this.goToBroadcastScreen()
        }

        //this.showcount()


    }
   /* private fun showcount(){
        //binding.tvGreeting.text= this.count.toString()
    }*/



    private fun goToLifecycleScreen(){
        // Toast.makeText(this,"Go To Broadcast Receiver",Toast.LENGTH_LONG).show()
        val intent=LifecycleActivity.getInstance(this)
        startActivity(intent)
    }
       private fun goToBroadcastScreen(){
          // Toast.makeText(this,"Go To Broadcast Receiver",Toast.LENGTH_LONG).show()
           val intent= BroadcastActivity.getInstance(this)
           startActivity(intent)
       }


  }