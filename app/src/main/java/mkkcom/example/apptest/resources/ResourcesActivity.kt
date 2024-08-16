package mkkcom.example.apptest.resources

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.intl.LocaleList
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityResourcesBinding
import mkkcom.example.apptest.helper.showToast
import mkkcom.example.apptest.userinterface.UserInterfaceActivity

class ResourcesActivity : BaseActivity<ActivityResourcesBinding>() {

    companion object {
        fun getInstance(context: Context): Intent {
            return Intent(context, ResourcesActivity::class.java)

        }
    }

    override val pageTitle: String get() = getString(R.string.resources)

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityResourcesBinding {
        return ActivityResourcesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.tvDynamicString.text = getString(
            R.string.label_dynamic_string,
            5, "apples", 3, "bananas"
        )

        updateUI()
        binding.btnChangeLanguage.setOnClickListener { this.changeLanguage() }
       // binding.btnChangeTheme.setOnClickListener { this.changeTheme() }

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        showToast("onConfigurationChanged")
        this.updateUI()


    }

    private fun updateUI() {
        binding.tvLocalizedString.text = getString(R.string.label_localized_string)
    }

    private fun changeLanguage() {
        val currentLanguage = resources.configuration.locales.get(0).language
        val newLanguage = if (currentLanguage == "en") "my" else "en"
        showToast("$currentLanguage to $newLanguage ")
        val locale = java.util.Locale(newLanguage)
        val localeListToSet = android.os.LocaleList(locale)
        android.os.LocaleList.setDefault(localeListToSet)

        @Suppress("DEPRECATION")
        resources.updateConfiguration(resources.configuration, resources.displayMetrics)
        recreate()

    }

    private var isDarkTheme = false // white

    private fun changeTheme() {
        showToast("changeTheme")

        if (isDarkTheme) {
             AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        recreate()
        isDarkTheme = !isDarkTheme

    }
}