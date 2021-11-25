package com.example.lykkehjul.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.lykkehjul.R


class vandtFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vandt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentStartNytSpil: Button = view.findViewById(R.id.fragmentStartNytSpil)

        fragmentStartNytSpil.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_vandtFragment_to_mainFragment)
        }

    }

}