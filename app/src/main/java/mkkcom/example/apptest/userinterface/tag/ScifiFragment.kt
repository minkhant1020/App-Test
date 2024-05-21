package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import mkkcom.example.apptest.databinding.FragmentScifiBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class ScifiFragment : BaseFragment<FragmentScifiBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentScifiBinding {
        return FragmentScifiBinding.inflate(Inflater,container,false)
    }

}