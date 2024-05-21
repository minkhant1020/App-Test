package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import mkkcom.example.apptest.databinding.FragmentHorrorBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class HorrorFragment : BaseFragment<FragmentHorrorBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentHorrorBinding {
        return FragmentHorrorBinding.inflate(Inflater,container,false)
    }

}