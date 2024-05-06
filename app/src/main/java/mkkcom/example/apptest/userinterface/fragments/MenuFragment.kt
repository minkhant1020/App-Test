package mkkcom.example.apptest.userinterface.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.CustomDialogBinding
import mkkcom.example.apptest.databinding.FragmentMenuBinding
import mkkcom.example.apptest.userinterface.SheetsActivity


class MenuFragment : BaseFragment<FragmentMenuBinding>() {



    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMenuBinding {
        return FragmentMenuBinding.inflate(Inflater,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnOne.setOnClickListener { showFragment(StepOneFragment.getInstance()) }
        binding.btnTwo.setOnClickListener { showFragment(StepTwoFragment.getInstance()) }
        binding.btnThree.setOnClickListener { showFragment(StepThreeFragment.getInstance()) }
        binding.btnFour.setOnClickListener {showFragment(StepFourFragment.getInstance())  }
        binding.btnBack.setOnClickListener {
           requireActivity().supportFragmentManager.popBackStack(
                StepTwoFragment::class.java.name,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
           // requireActivity().supportFragmentManager.popBackStackImmediate()

        }



    }




    private fun showFragment(fragment: Fragment){


        requireActivity().supportFragmentManager
            .beginTransaction()




            .setCustomAnimations(
                R.anim.slide_in_right, R.anim.slightly_slide_out_right,
                R.anim.slightly_slide_in_right, R.anim.slide_out_right)


            .replace(R.id.container_one,fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()


    }




}