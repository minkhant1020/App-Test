package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentChildBinding


class ChildFragment : BaseFragment<FragmentChildBinding>() {

    companion object{

        fun getInstance():ChildFragment{
            return ChildFragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentChildBinding {
        return FragmentChildBinding.inflate(Inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChildFragment2.setOnClickListener {showChild2Fragment(Child2Fragment.getInstance())}

    }

    private fun showChild2Fragment(fragment: Fragment) {


        requireActivity().supportFragmentManager
            .beginTransaction()


            .setCustomAnimations(
                R.anim.slide_in_right, R.anim.slightly_slide_out_right,
                R.anim.slightly_slide_in_right, R.anim.slide_out_right
            )


            .add(R.id.child_container_3, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()

    }



}