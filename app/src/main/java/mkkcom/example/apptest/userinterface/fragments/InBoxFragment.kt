package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentInBoxBinding


class InBoxFragment : BaseFragment<FragmentInBoxBinding>() {

    companion object{

        fun getInstance():InBoxFragment{
            return InBoxFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentInBoxBinding {
        return FragmentInBoxBinding.inflate(Inflater,container,false)
    }

}