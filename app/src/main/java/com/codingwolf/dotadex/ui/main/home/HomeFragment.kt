package com.codingwolf.dotadex.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.data.model.Match
import com.codingwolf.dotadex.di.ViewModelFactory
import com.codingwolf.dotadex.domain.util.DateUtil
import com.codingwolf.dotadex.ui.main.MainActivity
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

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

        homeViewModel.matches.observe(this, Observer(::updateMatchDetails))

        homeViewModel.error.observe(this, Observer {
            Log.d("HomeFragment", "Error:\n$it")
        })
    }

    private fun updateMatchDetails(matches: List<Match>) {
        matchAdapter.updateMatches(matches)

        var victories = 0f
        val entries = mutableListOf(Entry(0f, 0f))

        entries.addAll(
            matches.reversed().mapIndexed { index: Int, match: Match ->
                Entry(
                    index.toFloat() + 1,
                    if (match.isVictory) ++victories * 25 else --victories * 25
                )
            }
        )


        val dataSet = LineDataSet(entries, "Vitórias")
        dataSet.valueTextColor = requireContext().getColor(R.color.dotaDex_white)
        dataSet.setCircleColor(requireContext().getColor(R.color.dotaDex_green))
        val lineData = LineData(dataSet)

        lineChart_fragmentHome_gameChart.data = lineData
        lineChart_fragmentHome_gameChart.invalidate()
    }

    companion object {
        const val accountId = 76561198051747725
    }
}
