package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import mkkcom.example.apptest.databinding.FragmentDramaBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class DramaFragment : BaseFragment<FragmentDramaBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentDramaBinding {
        return FragmentDramaBinding.inflate(Inflater,container,false)
    }

}