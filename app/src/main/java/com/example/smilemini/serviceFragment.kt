package com.example.smilemini

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.smilemini.databinding.FragmentserviceBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

class serviceFragment:Fragment(R.layout.fragmentservice), CoroutineScope by MainScope()
{

    private var _binding: FragmentserviceBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //   FragmentserviceBinding.inflate(inflater,container,false)
           _binding= FragmentserviceBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}