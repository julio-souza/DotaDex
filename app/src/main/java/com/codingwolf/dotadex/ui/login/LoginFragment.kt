package com.codingwolf.dotadex.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.codingwolf.dotadex.R
import com.codingwolf.dotadex.di.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment(R.layout.fragment_login) {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: LoginViewModel by viewModels { factory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as LoginActivity).loginComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageButton_loginFragment_steamLogin.setOnClickListener {
            navigateTo(STEAM_FRAGMENT)
        }

        viewModel.onUserLocated.observe(viewLifecycleOwner, Observer {
            navigateTo(MAIN_ACTIVITY)
        })
    }

    private fun navigateTo(destination: Int) {
        findNavController().navigate(destination)
    }

    companion object {
        const val MAIN_ACTIVITY = R.id.action_loginFragment_to_mainActivity
        const val STEAM_FRAGMENT = R.id.action_loginFragment_to_steamFragment
    }
}
