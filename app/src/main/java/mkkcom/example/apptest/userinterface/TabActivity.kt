package mkkcom.example.apptest.userinterface

import android.content.Context
import android.content.Intent
import android.content.LocusId
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import androidx.activity.addCallback
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import mkkcom.example.apptest.BaseActivity
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.ActivityTabBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment
import mkkcom.example.apptest.userinterface.fragments.ChildFragment
import mkkcom.example.apptest.userinterface.fragments.SettingsFragment
import mkkcom.example.apptest.userinterface.fragments.StepTwoFragment
import mkkcom.example.apptest.userinterface.tag.ActionFragment
import mkkcom.example.apptest.userinterface.tag.ComedyFragment
import mkkcom.example.apptest.userinterface.tag.DramaFragment
import mkkcom.example.apptest.userinterface.tag.FirstLevelFragment
import mkkcom.example.apptest.userinterface.tag.HomeFragment
import mkkcom.example.apptest.userinterface.tag.HorrorFragment
import mkkcom.example.apptest.userinterface.tag.Language2Fragment
import mkkcom.example.apptest.userinterface.tag.LanguageFragment
import mkkcom.example.apptest.userinterface.tag.NotificationFragment
import mkkcom.example.apptest.userinterface.tag.ScifiFragment
import mkkcom.example.apptest.userinterface.tag.VideoFragment

class TabActivity : BaseActivity<ActivityTabBinding>() {
    companion object{


        fun getInstance(context: Context): Intent {
            return Intent(context, TabActivity ::class.java)

        }
    }
    override val pageTitle: String get() = "Tab bar"

    override fun setupViewBinding(layoutInflater: LayoutInflater): ActivityTabBinding {
        return ActivityTabBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this){ handleBackPress() }
        this.supportActionBar?.hide()
        this.setupTab()
    }
    private val homeFragment : HomeFragment by lazy { HomeFragment() }
    private val videoFragment : VideoFragment by lazy { VideoFragment() }
    private val notificationFragment : NotificationFragment by lazy { NotificationFragment() }

    private fun setupTab(){
        binding.bottomNavigation.menu.clear()
        Tab.entries.forEach {
           /* val tabItem = binding.tabLayout.newTab()
            tabItem.tag = it
            tabItem.text = getString(it.title)
            tabItem.icon = AppCompatResources.getDrawable(this,it.icon)
            binding.tabLayout.addTab(tabItem)*/

            binding.bottomNavigation.menu.add(
                Menu.NONE,
                it.id,
                Menu.NONE,
                it.title

            ).icon = ResourcesCompat.getDrawable(resources,it.icon,null)
        }
       // binding.tabLayout.addOnTabSelectedListener(tabSelectedListener)
        binding.bottomNavigation.setOnItemSelectedListener {
            selectedTab = Tab.getTabByItemId(it.itemId)
            true
        }
        selectedTab = Tab.entries.first()

    }


    private var selectedTab: Tab? = null
        set(value) {

            if (value==field || value == null) return
            binding.bottomNavigation.menu.findItem(value.id).isChecked = true
            field?.let { hideFragment(getFragmentByTab(it)) }
            showFragment(getFragmentByTab(value))
            Log.d("TAG", "Set selectedTab: $value ")
            field = value

        }

        get() {
            Log.d("TAG", "Get selectedTab: $field ")
            return field
        }

    private fun getFragmentByTab (tab: Tab): FirstLevelFragment<*>{
        return when (tab){
            Tab.HOME -> homeFragment
            Tab.VIDEO -> videoFragment
            Tab.NOTIFICATION -> notificationFragment

        }
    }
    private fun showFragment(fragment: Fragment){
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .show(it)
                .commit()

        } ?: run {
            supportFragmentManager
                .beginTransaction()
                //.addToBackStack(fragment.javaClass.name)
                .add(R.id.container,fragment,fragment.javaClass.name)
                .commit()
        }
    }
    private fun  hideFragment(fragment: Fragment) {
        supportFragmentManager.findFragmentByTag(fragment.javaClass.name)?.let {
            supportFragmentManager
                .beginTransaction()
                .hide(it)
                .commit()
        }
    }

    private enum class Tab (var id: Int,var title: Int,var icon: Int) {

        HOME (1,R.string.menu_home,R.drawable.ic_home),
        VIDEO (2,R.string.menu_video,R.drawable.ic_video),
        NOTIFICATION (3,R.string.menu_notification,R.drawable.ic_notification);
        companion object{
            fun getTabByItemId(itemId: Int): Tab?{
                return Tab.entries.find { it.id == itemId }

            }
        }
        /*val title = Tab.HOME.getTitleString(this)
            fun getTitleString(context: Context): String{
                return context.getString(title)
            }
*/
    }
    private fun handleBackPress() {
        if (supportFragmentManager.popBackStackImmediate()) {
            /** So it popped the dialog fragment back stack. */
        } else if (popBackChildFragment()) {
            /** So it popped the child fragment back stack. */
        } else if (selectedTab != Tab.entries.first()) {
            selectedTab = Tab.entries.first()
        } else {
            finish()
        }
    }

    private fun popBackChildFragment(): Boolean {
        return selectedTab?.let {
            getFragmentByTab(it).let { firstLevelFrag ->
                firstLevelFrag.isVisible && firstLevelFrag.onBackPressed()
            }
        } ?: false
    }
    fun navigateToLanguageSetting(){
        selectedTab?.let {
            (getFragmentByTab(it) ).showFragment(LanguageFragment())
        }

    }
    fun navigateToLanguage2Setting(){
        selectedTab?.let {
            (getFragmentByTab(it) ).showFragment(Language2Fragment())
        }

    }
    fun navigateBack(){
        onBackPressedDispatcher.onBackPressed()

    }
}