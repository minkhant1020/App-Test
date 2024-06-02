package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentSettingsBinding
import mkkcom.example.apptest.userinterface.tag.FirstLevelFragment


class SettingsFragment : FirstLevelFragment<FragmentSettingsBinding>() {

    companion object{

        fun getInstance():SettingsFragment{
            return SettingsFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(Inflater,container,false)
    }

}