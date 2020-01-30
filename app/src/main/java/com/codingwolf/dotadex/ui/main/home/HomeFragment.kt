package com.codingwolf.dotadex.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.di.ViewModelFactory
import com.codingwolf.dotadex.domain.util.DateUtil
import com.codingwolf.dotadex.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    @Inject
    lateinit var dateUtil: DateUtil

    private val homeViewModel by viewModels<HomeViewModel> { factory }

    private val matchAdapter by lazy { MatchAdapter(mutableListOf(), dateUtil) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).mainComponent.inject(this)
    }

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

        Toast.makeText(requireContext(), "User's Id -> $accountId", Toast.LENGTH_SHORT).show()

        initObserver()
        recyclerView_fragmentHome_match.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = matchAdapter
        }
    }

    private fun initObserver() {
        homeViewModel.player.observe(this, Observer { profile ->
            textView_fragmentHome_playerNickname.text =
                profile.profile.personaName
        })

        homeViewModel.matches.observe(this, Observer(matchAdapter::updateMatches))

        homeViewModel.error.observe(this, Observer {
            Log.d("HomeFragment", "Error:\n$it")
        })
    }

    companion object {
        const val accountId = 76561198051747725
    }
}
