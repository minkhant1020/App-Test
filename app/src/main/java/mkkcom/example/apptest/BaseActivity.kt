package mkkcom.example.apptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import mkkcom.example.apptest.databinding.ActivityMainBinding

abstract class BaseActivity <VB: ViewBinding> : AppCompatActivity() {

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}