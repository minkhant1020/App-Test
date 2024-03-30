package mkkcom.example.apptest

import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.broadcast.BroadcastActivity
import mkkcom.example.apptest.databinding.ActivityMainBinding
import mkkcom.example.apptest.intent.IntentActivity
import mkkcom.example.apptest.lifecycle.LifecycleActivity
import mkkcom.example.apptest.taskandbackstack.TaskAndBackStackActivity
import mkkcom.example.apptest.userinterface.UserInterfaceActivity
import java.util.Date

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
        binding.btnInTant.setOnClickListener {
            this.goToIntentActivity()
        }
        binding.btnTaskAndBackStack.setOnClickListener {
            this.goToTaskAndBackStackActivity()

        }
        binding.btnUserInterface.setOnClickListener {
            this.goToUserInterface()
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

    private fun goToIntentActivity(){

        val intent= IntentActivity.getInstance(this,Date().toString())
        startActivity(intent)

    }
    private fun goToTaskAndBackStackActivity(){

        val intent= TaskAndBackStackActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goToUserInterface(){

        val intent= UserInterfaceActivity.getInstance(this)
        startActivity(intent)

    }


  }