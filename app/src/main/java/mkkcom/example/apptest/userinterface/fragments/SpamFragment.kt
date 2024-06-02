package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentSpamBinding
import mkkcom.example.apptest.userinterface.tag.FirstLevelFragment


class SpamFragment : FirstLevelFragment<FragmentSpamBinding>() {

    companion object{

        fun getInstance():SpamFragment{
            return SpamFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentSpamBinding {
        return FragmentSpamBinding.inflate(Inflater,container,false)
    }

}