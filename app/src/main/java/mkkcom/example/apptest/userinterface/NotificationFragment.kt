package mkkcom.example.apptest.userinterface

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentNotificationBinding
import mkkcom.example.apptest.userinterface.fragments.BaseFragment


class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(Inflater,container,false)
    }

}