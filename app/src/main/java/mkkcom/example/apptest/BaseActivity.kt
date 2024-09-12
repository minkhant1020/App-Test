package mkkcom.example.apptest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import mkkcom.example.apptest.database.entity.ProductSS
import mkkcom.example.apptest.databinding.ActivityMainBinding
import mkkcom.example.apptest.helper.AirplaneModeChange
import mkkcom.example.apptest.helper.ScreenChang
import mkkcom.example.apptest.helper.showToast
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity<VB: ViewBinding>  : AppCompatActivity() {


    protected lateinit var binding: VB
    abstract val pageTitle: String
    abstract fun setupViewBinding(layoutInflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=setupViewBinding(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title=pageTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(this !is MainActivity)


    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "on New Intent", Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: AirplaneModeChange){
        showToast("Airplane Mode Change")

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: ScreenChang){
        showToast("Screen Change")

    }



}