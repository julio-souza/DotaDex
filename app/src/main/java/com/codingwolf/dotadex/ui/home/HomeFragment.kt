package com.codingwolf.dotadex.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.di.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val homeViewModel by viewModels<HomeViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "User's Id -> $userId", Toast.LENGTH_SHORT).show()

        initObserver()
    }

    private fun initObserver() {
        homeViewModel.profile.observe(this, Observer { profile ->
            textView_fragmentHome_playerNickname.text =
                profile.response.playerProfiles[0].personaName
        })
    }

    companion object {
        const val userId = 76561198051747725
    }
}
