package mkkcom.example.apptest


import android.os.Bundle
import android.view.LayoutInflater
import android.window.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import mkkcom.example.apptest.broadcast.BroadcastActivity
import mkkcom.example.apptest.database.DataBaseSSActivity
import mkkcom.example.apptest.database.DatabaseActivity
import mkkcom.example.apptest.database.entity.ProductSS
import mkkcom.example.apptest.databinding.ActivityMainBinding
import mkkcom.example.apptest.intent.IntentActivity
import mkkcom.example.apptest.lifecycle.LifecycleActivity
import mkkcom.example.apptest.resources.ResourcesActivity
import mkkcom.example.apptest.sharepreference.SharePreferenceActivity
import mkkcom.example.apptest.taskandbackstack.TaskAndBackStackActivity
import mkkcom.example.apptest.userinterface.UserInterfaceActivity
import java.util.Date

class MainActivity : BaseActivity< ActivityMainBinding>() {


    override val pageTitle: String get() ="Main Menu"
    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        installSplashScreen()

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
        binding.btnResources.setOnClickListener {
            this.goToResources()
        }
        binding.btnSharePreference.setOnClickListener {
            this.goToSharePreference()
        }
        binding.btnDatabase.setOnClickListener {
            this.goToDatabase()
        }
        binding.btnDatabaseSS.setOnClickListener {
            this.goToDatabaseSS()
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

    private fun goToResources(){

        val intent= ResourcesActivity.getInstance(this)
        startActivity(intent)

    }

    private fun goToSharePreference(){

        val intent= SharePreferenceActivity.getInstance(this)
        startActivity(intent)

    }

    private fun goToDatabase(){

        val intent= DatabaseActivity.getInstance(this)
        startActivity(intent)

    }
    private fun goToDatabaseSS(){

        val intent= DataBaseSSActivity.getInstance(this)
        startActivity(intent)

    }


  }