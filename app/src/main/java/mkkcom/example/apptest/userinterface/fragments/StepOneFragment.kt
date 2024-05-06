package mkkcom.example.apptest.userinterface.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentStepOneBinding
import mkkcom.example.apptest.userinterface.SheetsActivity


class StepOneFragment : BaseFragment<FragmentStepOneBinding>() {
    companion object{

        fun getInstance():StepOneFragment{
            return StepOneFragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStepOneBinding {
       return FragmentStepOneBinding.inflate(Inflater,container,false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("Tag", "onAttach: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Tag", "onCreate: ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("Tag", "onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Tag", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Tag", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Tag", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Tag", "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Tag", "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Tag", "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Tag", "onDetach: ")
    }


}