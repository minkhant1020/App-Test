package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentHomeBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment
import mkkcom.example.apptest.userinterface.fragments.Child2Fragment
import mkkcom.example.apptest.userinterface.fragments.ChildFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    companion object {

        fun getInstance(): HomeFragment {
            return HomeFragment()

        }
    }

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(Inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.visibility = View.GONE

        binding.btnChildFragment.setOnClickListener { showChildFragment (ChildFragment.getInstance())
            binding.btnBack.visibility= View.VISIBLE}


        binding.btnBack.setOnClickListener {
            binding.btnBack.visibility = View.GONE

                requireActivity().supportFragmentManager.popBackStack(
                    ChildFragment::class.java.name,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE

                )
                // requireActivity().supportFragmentManager.popBackStackImmediate()


        }




    }
    private fun showChildFragment(fragment: Fragment) {


        requireActivity().supportFragmentManager
            .beginTransaction()


            .setCustomAnimations(
                R.anim.slide_in_right, R.anim.slightly_slide_out_right,
                R.anim.slightly_slide_in_right, R.anim.slide_out_right
            )


            .replace(R.id.child_container_2, fragment)
            .addToBackStack(fragment.javaClass.name)
            .commit()


    }
}
