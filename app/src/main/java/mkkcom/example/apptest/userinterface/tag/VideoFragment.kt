package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentVideoBinding
import mkkcom.example.apptest.userinterface.TabActivity
import mkkcom.example.apptest.userinterface.fragments.BaseFragment
import mkkcom.example.apptest.userinterface.fragments.ChildFragment


class VideoFragment : BaseFragment<FragmentVideoBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentVideoBinding {
        return FragmentVideoBinding.inflate(Inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        this.setupVideoTab()
    }


    private val actionFragment: ActionFragment by lazy { ActionFragment() }
    private val comedyFragment: ComedyFragment by lazy { ComedyFragment() }
    private val horrorFragment: HorrorFragment by lazy { HorrorFragment() }
    private val dramaFragment: DramaFragment by lazy { DramaFragment() }
    private val scifiFragment: ScifiFragment by lazy { ScifiFragment() }

    private fun setupVideoTab(){
        VideoFragment.VideoTab.entries.forEach {
            val tabItem = binding.childTabLayout.newTab()
            tabItem.tag = it
            tabItem.text = getString(it.title)
            binding.childTabLayout.addTab(tabItem)
        }
        binding.childTabLayout.addOnTabSelectedListener(tabSelectedListener)
        selectedTab = VideoFragment.VideoTab.entries.get(binding.childTabLayout.selectedTabPosition)

    }




    private val tabSelectedListener by lazy {
        object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(p1: TabLayout.Tab?) {
                Log.d("TAG", "onTabSelected: ")

                p1?.let {
                    selectedTab = it.tag as VideoTab
                }

            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        }

    }

    private var selectedTab: VideoTab? = null
        set(value) {

            if (value==field || value == null) return

            showChildFragment(getFragmentByTab(value))
            Log.d("TAG", "Set selectedTab: $value ")
            field = value

        }

        get() {
            Log.d("TAG", "Get selectedTab: $field ")
            return field
        }

    private fun getFragmentByTab (videoTab: VideoTab): Fragment{
        return when(videoTab){
            VideoTab.ACTION -> actionFragment
            VideoTab.COMEDY -> comedyFragment
            VideoTab.HORROR -> horrorFragment
            VideoTab.DRAMA -> dramaFragment
            VideoTab.SCIFI -> scifiFragment
        }
    }
    private fun showChildFragment(fragment: Fragment) {



        requireActivity().supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in_right, R.anim.slightly_slide_out_right,
                R.anim.slightly_slide_in_right, R.anim.slide_out_right
            )
            .addToBackStack(fragment.javaClass.name)
            .replace(R.id.child_container, fragment,fragment.javaClass.name)
            .commit()


    }
    private enum class VideoTab(var title: Int) {
        ACTION(R.string.menu_action),
        COMEDY(R.string.menu_comedy),
        HORROR(R.string.menu_horror),
        DRAMA(R.string.menu_drama),
        SCIFI(R.string.menu_scifi)
    }
}