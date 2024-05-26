package mkkcom.example.apptest.userinterface.tag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentNotificationBinding
import mkkcom.example.apptest.userinterface.TabActivity
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class NotificationFragment : FirstLevelFragment<FragmentNotificationBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(Inflater,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLanguageChange.setOnClickListener {
            (requireActivity() as? TabActivity)?.navigateToLanguageSetting()
        }
        binding.btnAboutUs.setOnClickListener {
            (requireActivity() as? TabActivity)?.navigateToAboutUs()
        }
    }

}