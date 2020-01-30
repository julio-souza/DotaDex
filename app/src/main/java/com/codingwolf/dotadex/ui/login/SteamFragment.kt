package com.codingwolf.dotadex.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.util.SteamUtil
import kotlinx.android.synthetic.main.fragment_steam.*

class SteamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_steam, container, false)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onStart() {
        super.onStart()

        val url = "https://steamcommunity.com/openid/login?" +
                "openid.claimed_id=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.identity=http://specs.openid.net/auth/2.0/identifier_select&" +
                "openid.mode=checkid_setup&" +
                "openid.ns=http://specs.openid.net/auth/2.0&" +
                "openid.realm=https://" + "DotaDex" + "&" +
                "openid.return_to=https://" + "DotaDex" + "/signin/"

        webView_steamFragment_main.apply {
            settings.javaScriptEnabled = true
            webViewClient = SteamWebClient(::handleaccountId)
            loadUrl(url)
        }
    }

    //todo save the accountId and move to the mainActivity
    private fun handleaccountId(accountId: Long) {
        Log.d("SteamId", SteamUtil.getSteam32Id(accountId).toString())

        findNavController().navigate(R.id.action_steamFragment_to_mainActivity)
    }
}
