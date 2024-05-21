package mkkcom.example.apptest.userinterface

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import mkkcom.example.apptest.userinterface.tag.HomeFragment
import mkkcom.example.apptest.userinterface.tag.NotificationFragment
import mkkcom.example.apptest.userinterface.tag.VideoFragment

private const val NUM_TABS = 3

class TabPageChange(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle)  {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HomeFragment()
            1 -> return VideoFragment()
        }
        return NotificationFragment()
    }
    }


