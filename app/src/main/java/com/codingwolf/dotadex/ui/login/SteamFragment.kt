package com.codingwolf.dotadex.ui.login

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.di.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_steam.*
import javax.inject.Inject

class SteamFragment : Fragment(R.layout.fragment_steam) {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel by viewModels<LoginViewModel> { factory }

    private val userLocatedObserver = Observer<Unit> {
        findNavController().navigate(R.id.action_steamFragment_to_mainActivity)
    }

    private val errorOnLoadingUser = Observer<String> {
        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as LoginActivity).loginComponent.inject(this)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onStart() {
        super.onStart()

        webView_steamFragment_main.apply {
            settings.javaScriptEnabled = true
            webViewClient = SteamWebClient(::handleAccountId)
            loadUrl(URL)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onUserLocated.observe(viewLifecycleOwner, userLocatedObserver)
        viewModel.onFailToLocateUser.observe(viewLifecycleOwner, errorOnLoadingUser)
    }

    private fun handleAccountId(accountId: Long) {
        viewModel.initializeUser(accountId)
    }

    companion object {
        const val URL = "https://steamcommunity.com/openid/login?" +
                "openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.identity=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.mode=checkid_setup&" +
                "openid.ns=http://specs.openid.net/auth/2.0&" +
                "openid.realm=https://" + "DotaDex" + "&" +
                "openid.return_to=https://" + "DotaDex" + "/signin/"
    }
}
