package mkkcom.example.apptest.userinterface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mkkcom.example.apptest.R
import mkkcom.example.apptest.databinding.FragmentTrashBinding
import mkkcom.example.apptest.userinterface.tag.FirstLevelFragment


class TrashFragment : FirstLevelFragment<FragmentTrashBinding>() {

    companion object{

        fun getInstance():TrashFragment{
            return TrashFragment()

        }
    }
    override fun setupViewBinding(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentTrashBinding {
        return FragmentTrashBinding.inflate(Inflater,container,false)
    }

}