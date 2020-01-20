package com.codingwolf.dotadex.ui.login

import android.net.Uri
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


class SteamWebClient(val handleUserId: (Long) -> Unit) : WebViewClient() {


    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        Log.i("Resposta", request?.url.toString())

        request?.url?.let { url ->
            if (url.authority?.contains("dotadex") == true) {
                view?.stopLoading()

                val userAccountUrl: Uri = Uri.parse(url.getQueryParameter("openid.identity"))
                val userId: String? = userAccountUrl.lastPathSegment

                userId?.toLongOrNull()?.let { handleUserId(it) }
                return false
            }
        }

        return super.shouldOverrideUrlLoading(view, request)
    }
}
