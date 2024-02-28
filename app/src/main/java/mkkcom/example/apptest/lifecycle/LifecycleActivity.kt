package mkkcom.example.apptest.lifecycle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.addCallback
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.broadcast.BroadcastActivity
import mkkcom.example.apptest.databinding.ActivityBroadcastBinding
import mkkcom.example.apptest.databinding.ActivityLifecycleBinding

class LifecycleActivity : BaseActivity<ActivityLifecycleBinding>() {

    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context,LifecycleActivity::class.java)
        }
    }
    override val pageTitle: String get() ="Activity Lifecycle"


    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityLifecycleBinding {
        return ActivityLifecycleBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG","onCreate")


        onBackPressedDispatcher.addCallback {
            Log.d("TAG","onBackPressedDispatcher")
            finish()
        }
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