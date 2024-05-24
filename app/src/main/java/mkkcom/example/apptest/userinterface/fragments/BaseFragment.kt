package mkkcom.example.apptest.userinterface.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import androidx.viewbinding.ViewBinding
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentNoTitleBinding
import mkkcom.example.apptest.databinding.FragmentWithTitleBinding
import mkkcom.example.apptest.userinterface.TabActivity
import mkkcom.example.apptest.userinterface.tag.FirstLevelFragment
import mkkcom.example.apptest.userinterface.tag.HomeFragment
import mkkcom.example.apptest.userinterface.tag.NotificationFragment
import mkkcom.example.apptest.userinterface.tag.VideoFragment

abstract class BaseFragment<VB: ViewBinding>:Fragment() {


    protected lateinit var binding: VB
    protected open var pageTitle: String? = null
    abstract fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setupViewBinding(inflater, container, savedInstanceState)
        if (this is FirstLevelFragment) {
            val baseFragmentBinding = FragmentNoTitleBinding.inflate(inflater, container, false)
            baseFragmentBinding.fragmentContainer.removeAllViews()
            baseFragmentBinding.fragmentContainer.addView(binding.root)
            return baseFragmentBinding.root
        }else{
            val baseFragmentBinding = FragmentWithTitleBinding.inflate(inflater, container, false)
            baseFragmentBinding.fragmentContainer.removeAllViews()
            baseFragmentBinding.fragmentContainer.addView(binding.root)
            baseFragmentBinding.toolbar.title = pageTitle
            baseFragmentBinding.toolbar.setNavigationIcon(R.drawable.ic_back_arrow)
            baseFragmentBinding.toolbar.setNavigationOnClickListener {
                (requireActivity() as? TabActivity)?.navigateBack()
            }
            return baseFragmentBinding.root
        }


    }


}


