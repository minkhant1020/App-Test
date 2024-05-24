package mkkcom.example.apptest.userinterface.tag

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import mkkcom.example.apptest.R
import mkkcom.example.apptest.userinterface.fragments.BaseFragment

abstract class FirstLevelFragment<VB: ViewBinding>: BaseFragment<VB>() {

    fun showFragment(
        fragment: Fragment,
        replace: Boolean = false,
        addToBackStack: Boolean = true
    ) {
        val transaction = childFragmentManager.beginTransaction().apply {
            if (addToBackStack) { addToBackStack(fragment.javaClass.name) }
        }
        if (replace) {
            transaction.replace(R.id.fragment_container, fragment)
        } else {
            transaction.add(R.id.fragment_container, fragment)
        }
        transaction.commit()
    }
    fun onBackPressed(): Boolean{
        return childFragmentManager.popBackStackImmediate()
    }
}