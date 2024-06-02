package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentAboutUsBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class AboutUsFragment : FirstLevelFragment<FragmentAboutUsBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentAboutUsBinding {
        return FragmentAboutUsBinding.inflate(Inflater,container,false)
    }

}