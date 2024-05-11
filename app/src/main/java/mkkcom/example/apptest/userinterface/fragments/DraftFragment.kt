package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentDraftBinding


class DraftFragment : BaseFragment<FragmentDraftBinding>() {

    companion object{

        fun getInstance():DraftFragment{
            return DraftFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentDraftBinding {
        return FragmentDraftBinding.inflate(Inflater,container,false)
    }

}