package com.hemmati.coroutineskoinsampleproject.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.hemmati.coroutineskoinsampleproject.R
import com.hemmati.coroutineskoinsampleproject.utils.isNetworkAvailable
import com.hemmati.coroutineskoinsampleproject.utils.showIf
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.android.viewmodel.ext.android.viewModel

const val USER_NAME = "userName"

class ProfileFragment : Fragment() {
    private var userName: String? = null
    private val profileViewModel: ProfileViewMode by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(USER_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isNetworkAvailable())
            userName?.let { profileViewModel.getProfile(it) }
        else
            Toast.makeText(
                activity, getString(R.string.network_conection_error),
                Toast.LENGTH_LONG
            ).show()

        with(profileViewModel) {
            profileData.observe(viewLifecycleOwner, {
                Picasso.get().load(it.profile.pic_b).fit()
                    .error(R.drawable.ic_baseline_terrain_24).into(profileImage)
                userNameTextView.text = it.profile.name
                urlTextView.text = it.profile.url
            })


            showProgressbar.observe(viewLifecycleOwner, { isShow ->
                progressBar.showIf { isShow }
                parent.showIf { !isShow }

            })

            messageData.observe(viewLifecycleOwner, {
                Toast.makeText(activity, it, Toast.LENGTH_LONG).show()
            })
        }


    }

}