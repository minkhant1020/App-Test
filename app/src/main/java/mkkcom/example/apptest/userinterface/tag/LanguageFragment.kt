package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentLanguageBinding
import mkkcom.example.apptest.userinterface.TabActivity
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class LanguageFragment : BaseFragment<FragmentLanguageBinding>() {
    override var pageTitle: String? = "Change Language"


    companion object {

        fun getInstance(): LanguageFragment {
            return LanguageFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentLanguageBinding {
        return FragmentLanguageBinding.inflate(Inflater,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLanguage2.setOnClickListener {
            (requireActivity() as? TabActivity)?.navigateToLanguage2Setting()
        }
    }

}