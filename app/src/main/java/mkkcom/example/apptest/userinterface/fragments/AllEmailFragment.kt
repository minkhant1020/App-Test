package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentAllEmailBinding


class AllEmailFragment : BaseFragment<FragmentAllEmailBinding>() {

    companion object{

        fun getInstance():AllEmailFragment{
            return AllEmailFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentAllEmailBinding {
        return FragmentAllEmailBinding.inflate(Inflater,container,false)
    }

}