package com.hemmati.coroutineskoinsampleproject.presentation.videos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hemmati.coroutineskoinsampleproject.R
import com.hemmati.coroutineskoinsampleproject.presentation.profile.USER_NAME
import com.hemmati.coroutineskoinsampleproject.utils.isNetworkAvailable
import com.hemmati.coroutineskoinsampleproject.utils.showIf
import kotlinx.android.synthetic.main.fragment_videos.*
import org.koin.android.viewmodel.ext.android.viewModel


class VideosFragment : Fragment(R.layout.fragment_videos) {
    private val videosViewModel: VideosViewModel by viewModel()
    private lateinit var mVideosAdapter: VideosAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        onClicksAction()
        viewModelStartAndObserved()
    }

    private fun onClicksAction() {
        mVideosAdapter.onItemClick = {

            val arg = bundleOf(USER_NAME to it.username)
            findNavController().navigate(R.id.profileFragment, arg)

        }
    }

    private fun initialRecyclerView() {
        videosRecyclerView.apply {
            mVideosAdapter = VideosAdapter()
            layoutManager = LinearLayoutManager(activity)
            adapter = mVideosAdapter
        }
    }

    private fun viewModelStartAndObserved() {

        if (isNetworkAvailable())
            videosViewModel.getVideos()
        else
            Toast.makeText(
                activity, getString(R.string.network_conection_error),
                Toast.LENGTH_LONG
            ).show()

        with(videosViewModel) {
            videosData.observe(viewLifecycleOwner, {
                mVideosAdapter.videos = it.mostviewedvideos
            })
            showProgressbar.observe(viewLifecycleOwner, { state ->
                progressBar.showIf { state }
            })
            messageData.observe(viewLifecycleOwner, {
                Toast.makeText(
                    activity, it,
                    Toast.LENGTH_LONG
                ).show()
            })
        }
    }
}