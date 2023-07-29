package com.chainreaction.moviesassignmentapp.presentations.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.chainreaction.caching.util.backupDatabase
import com.chainreaction.core.bases.BaseFragment
import com.chainreaction.core.extensions.collectLatest
import com.chainreaction.core.extensions.showToast
import com.chainreaction.moviesassignmentapp.R
import com.chainreaction.moviesassignmentapp.databinding.FragmentHomeBinding
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    private val tvShowAdapter by lazy { TvShowAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMostPopularService()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataBinding()
        collectLatest(viewModel.tvShowsSuccess, ::handleTvShowsSuccess)
        collectLatest(viewModel.state, ::handleViewState)
        viewLifecycleOwner.collectLatest(viewModel.eventState, ::handleMoreState)

    }

    private fun initDataBinding() {
        viewBinding?.adapter = tvShowAdapter
        viewBinding?.viewModel = viewModel

        tvShowAdapter.setOnItemClickListener { _, model, _ ->
            requireContext().showToast(model.name)
        }
    }

    private fun handleTvShowsSuccess(tvShows: ArrayList<TvShow>?) {
        viewBinding?.tvShows = tvShows?.toCollection(ArrayList())
    }

    private fun handleMoreState(viewState: HomeEventState) {
        when (viewState) {
            is HomeEventState.ShareDataBase -> {
                requireActivity().backupDatabase()
            }
        }
    }
}