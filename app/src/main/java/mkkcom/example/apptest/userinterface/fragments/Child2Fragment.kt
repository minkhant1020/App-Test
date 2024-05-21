package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentChild2Binding


class Child2Fragment : BaseFragment<FragmentChild2Binding>() {

    companion object {

        fun getInstance(): Child2Fragment {
            return Child2Fragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentChild2Binding {
        return FragmentChild2Binding.inflate(Inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}