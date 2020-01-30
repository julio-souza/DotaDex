package com.codingwolf.dotadex.ui.login

import android.net.Uri
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


class SteamWebClient(val handleaccountId: (Long) -> Unit) : WebViewClient() {


    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean =
        request?.url?.let { url ->
            if (url.authority?.contains("dotadex") == true) {
                view?.stopLoading()

                val userAccountUrl: Uri = Uri.parse(url.getQueryParameter("openid.identity"))
                val accountId: String? = userAccountUrl.lastPathSegment

                accountId?.toLongOrNull()?.let { handleaccountId(it) }
                return false
            }
            super.shouldOverrideUrlLoading(view, request)
        } ?: super.shouldOverrideUrlLoading(view, request)

}
