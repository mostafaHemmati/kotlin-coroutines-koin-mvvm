package com.hemmati.coroutineskoinsampleproject.presentation.videos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hemmati.coroutineskoinsampleproject.R
import com.hemmati.coroutineskoinsampleproject.presentation.profile.ProfileFragment
import kotlinx.android.synthetic.main.fragment_videos.*
import org.koin.android.viewmodel.ext.android.viewModel


class VideosFragment : Fragment() {
    private val videosViewModel: VideosViewModel by viewModel()
    private var mVideosAdapter: VideosAdapter? = VideosAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_videos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialRecyclerView()
        onClicksAction()
        viewModelStartAndObserved()
    }

    private fun onClicksAction() {
        mVideosAdapter?.onItemClick = {

            val fragment = ProfileFragment.newInstance(it.username)
            val transaction = activity?.supportFragmentManager?.beginTransaction()

            transaction?.let {
                transaction.apply {
                    replace(R.id.screenContainer, fragment)
                    disallowAddToBackStack()
                    commit()
                }

            }

        }
    }

    private fun initialRecyclerView() {
        videosRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mVideosAdapter
        }
    }

    private fun viewModelStartAndObserved() {
        videosViewModel.getVideos()

        with(videosViewModel) {
            videosData.observe(viewLifecycleOwner, {
                mVideosAdapter?.videos = it.mostviewedvideos
            })
            showProgressbar.observe(viewLifecycleOwner, {
                progressBar.visibility =
                    if (it) View.VISIBLE else View.GONE
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