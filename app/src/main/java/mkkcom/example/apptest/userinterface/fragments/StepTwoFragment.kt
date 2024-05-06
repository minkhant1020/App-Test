package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentStepTwoBinding


class StepTwoFragment : BaseFragment<FragmentStepTwoBinding>() {

    companion object{

        fun getInstance():StepTwoFragment{
            return StepTwoFragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepTwoBinding {
        return FragmentStepTwoBinding.inflate(Inflater,container,false)
    }


}