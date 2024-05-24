package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentLanguage2Binding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class Language2Fragment : BaseFragment<FragmentLanguage2Binding>() {
    override var pageTitle: String? = "Other Page"

    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentLanguage2Binding {
        return FragmentLanguage2Binding.inflate(Inflater,container,false)
    }


}