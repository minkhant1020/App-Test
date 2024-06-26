package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentAboutUsBinding


class AboutUsFragment : BaseFragment<FragmentAboutUsBinding>() {

    companion object{

        fun getInstance():AboutUsFragment{
            return AboutUsFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentAboutUsBinding {
        return FragmentAboutUsBinding.inflate(Inflater,container,false)
    }

}