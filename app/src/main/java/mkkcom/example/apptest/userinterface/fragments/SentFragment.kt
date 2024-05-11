package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentSentBinding


class SentFragment : BaseFragment<FragmentSentBinding>() {

    companion object{

        fun getInstance():SentFragment{
            return SentFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSentBinding {
        return FragmentSentBinding.inflate(Inflater,container,false)
    }

}