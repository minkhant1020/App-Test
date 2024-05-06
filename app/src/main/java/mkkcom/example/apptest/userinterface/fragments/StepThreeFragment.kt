package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentStepThreeBinding


class StepThreeFragment : BaseFragment<FragmentStepThreeBinding>() {
    companion object{

        fun getInstance():StepThreeFragment{
            return StepThreeFragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepThreeBinding {
        return FragmentStepThreeBinding.inflate(Inflater,container,false)
    }

}