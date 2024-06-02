package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R

import mkkcom.example.apptest.databinding.ActivityDrawerBinding
import mkkcom.example.apptest.userinterface.fragments.AboutUsFragment
import mkkcom.example.apptest.userinterface.fragments.AllEmailFragment
import mkkcom.example.apptest.userinterface.fragments.DraftFragment
import mkkcom.example.apptest.userinterface.fragments.InBoxFragment
import mkkcom.example.apptest.userinterface.fragments.SentFragment
import mkkcom.example.apptest.userinterface.fragments.SettingsFragment
import mkkcom.example.apptest.userinterface.fragments.SpamFragment
import mkkcom.example.apptest.userinterface.fragments.SupportFragment
import mkkcom.example.apptest.userinterface.fragments.TrashFragment

class DrawerActivity : BaseActivity<ActivityDrawerBinding>() {

    companion object {


        fun getInstance(context: Context): Intent {
            return Intent(context, DrawerActivity::class.java)

        }
    }



    override val pageTitle: String get() = "Drawer Activity"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityDrawerBinding {
        return ActivityDrawerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        this.supportActionBar?.hide()
        binding.btnOpen.setOnClickListener {
            binding.drawerLayout.open()
            this.setupDrawer()
        }

        }






    private val allEmailFragment: AllEmailFragment by lazy { AllEmailFragment() }
    private val inBoxFragment: InBoxFragment by lazy { InBoxFragment() }
    private val sentFragment: SentFragment by lazy { SentFragment() }
    private val draftFragment: DraftFragment by lazy { DraftFragment() }
    private val spamFragment: SpamFragment by lazy { SpamFragment() }
    private val trashFragment: TrashFragment by lazy { TrashFragment() }
    private val settingsFragment: SettingsFragment by lazy { SettingsFragment() }
    private val supportFragment: SupportFragment by lazy { SupportFragment() }
    private val aboutUsFragment: AboutUsFragment by lazy { AboutUsFragment() }

    private fun setupDrawer() {
        binding.navigationView.menu.clear()
        Drawer.entries.forEach {
            /* val tabItem = binding.tabLayout.newTab()
             tabItem.tag = it
             tabItem.text = getString(it.title)
             tabItem.icon = AppCompatResources.getDrawable(this,it.icon)
             binding.tabLayout.addTab(tabItem)*/

            binding.navigationView.menu.add(
                Menu.NONE,
                it.id,
                Menu.NONE,
                it.title

            ).icon = ResourcesCompat.getDrawable(resources, it.icon, null)
        }
        // binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
        binding.navigationView.setNavigationItemSelectedListener{
            selectedTab = Drawer.getTabByItemId(it.itemId)
            true
        }
        selectedTab = Drawer.entries.first()
    }

    private var selectedTab: Drawer? = null
        set(value) {
            if (field == value || value == null) return

            binding.navigationView.menu.findItem(value.id).isChecked = true

            field?.let { hideFragment(getFragmentByDrawer(it)) }
            showFragment(getFragmentByDrawer(value))

            Log.d("TAG", "Set selectedTab: $value")
            field = value
        }
        get() {
            Log.d("TAG", "Get selectedTab: $field")
            return field
        }

    private fun getFragmentByDrawer(drawer: Drawer): Fragment {
        return when (drawer) {
            Drawer.ALL_MAIL -> allEmailFragment
            Drawer.INBOX -> inBoxFragment
            Drawer.SENT -> sentFragment
            Drawer.DRAFT -> draftFragment
            Drawer.SPAM -> spamFragment
            Drawer.TRASH -> trashFragment
            Drawer.SETTINGS -> settingsFragment
            Drawer.SUPPORT -> supportFragment
            Drawer.ABOUT_US -> aboutUsFragment
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .show(it)
                .commit()

        } ?: run {
            supportFragmentManager
                .beginTransaction()
                //.addToBackStack(fragment.javaClass.name)
                .add(R.id.container, fragment, fragment.javaClass.name)
                .commit()
        }
    }

    private fun hideFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .hide(it)
                .commit()
        }
    }



    private enum class Drawer(var id: Int, var title: Int, var icon: Int) {

        ALL_MAIL(0, R.string.menu_all_mail, R.drawable.ic_mail),
        INBOX(1, R.string.menu_inbox, R.drawable.ic_inbox),
        SENT(2, R.string.menu_sent, R.drawable.ic_sent),
        DRAFT(3, R.string.menu_draft, R.drawable.ic_draft),
        SPAM(4, R.string.menu_spam, R.drawable.ic_spam),
        TRASH(5, R.string.menu_trash, R.drawable.ic_trash),
        SETTINGS(6, R.string.menu_settings, R.drawable.ic_setting),
        SUPPORT(7, R.string.menu_support, R.drawable.ic_support),
        ABOUT_US(8, R.string.menu_about_us, R.drawable.ic_about_us);


        companion object {
            fun getTabByItemId(itemId: Int): Drawer? {
                return Drawer.entries.find { it.id == itemId }
            }



        }

    }
}















