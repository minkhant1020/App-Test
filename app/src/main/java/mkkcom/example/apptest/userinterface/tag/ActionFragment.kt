package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import mkkcom.example.apptest.databinding.FragmentActionBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class ActionFragment : BaseFragment<FragmentActionBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentActionBinding {
        return FragmentActionBinding.inflate(Inflater,container,false)
    }

}