package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentSupportBinding
import mkkcom.example.apptest.userinterface.tag.FirstLevelFragment


class SupportFragment : FirstLevelFragment<FragmentSupportBinding>() {
    companion object{

        fun getInstance():SupportFragment{
            return SupportFragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSupportBinding {
        return FragmentSupportBinding.inflate(Inflater,container,false)
    }
}