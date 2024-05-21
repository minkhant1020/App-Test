package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import mkkcom.example.apptest.databinding.FragmentComedyBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class ComedyFragment : BaseFragment<FragmentComedyBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentComedyBinding {
        return FragmentComedyBinding.inflate(Inflater,container,false)
    }

}