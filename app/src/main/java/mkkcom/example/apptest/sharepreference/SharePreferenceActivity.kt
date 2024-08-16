package mkkcom.example.apptest.sharepreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivitySharePreferenceBinding
import mkkcom.example.apptest.userinterface.DrawerActivity

class SharePreferenceActivity : BaseActivity<ActivitySharePreferenceBinding>() {

    companion object {
        private const val NAME = "name"


        fun getInstance(context: Context): Intent {
            return Intent(context, SharePreferenceActivity::class.java)

        }
    }
    override val pageTitle: String  = "Share Preference"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivitySharePreferenceBinding {
        return ActivitySharePreferenceBinding.inflate(layoutInflater)
    }

    private val sharePreferences: SharedPreferences by lazy {
        getSharedPreferences("my Preference",Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.loadData()
        binding.btnSave.setOnClickListener { this.saveData() }

    }
    private fun loadData(){
        val name = sharePreferences.getString(NAME,null)
        binding.edtName.setText(name)

    }
    private fun saveData(){
        val name =binding.edtName.text.toString()
        val myEdit: SharedPreferences.Editor = sharePreferences.edit()

        myEdit.putString(NAME,name)
        myEdit.apply()


    }
}