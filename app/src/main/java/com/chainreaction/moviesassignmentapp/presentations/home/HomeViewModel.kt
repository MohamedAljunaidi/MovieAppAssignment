package com.chainreaction.moviesassignmentapp.presentations.home

import com.chainreaction.core.bases.BaseViewModel
import com.chainreaction.core.bases.BaseViewState
import com.chainreaction.core.bases.ResultWrapper
import com.chainreaction.moviesassignmentapp.domain.home.model.TvShow
import com.chainreaction.moviesassignmentapp.domain.home.usecases.GetTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase
) : BaseViewModel() {

    private var _tvShowsSuccess: MutableSharedFlow<ArrayList<TvShow>?> =
        MutableSharedFlow(replay = 1)

    val tvShowsSuccess: SharedFlow<ArrayList<TvShow>?> = _tvShowsSuccess.asSharedFlow()


    private var _eventState: MutableSharedFlow<HomeEventState> =
        MutableSharedFlow()
    val eventState: SharedFlow<HomeEventState> =
        _eventState.asSharedFlow()

    fun getMostPopularService() = launchCoroutine(coroutineExceptionHandler) {
        getTvShowsUseCase().onStart {
                _state.emit(BaseViewState.Loading)
            }.onCompletion {
                _state.emit(BaseViewState.DataLoaded)
            }.collectLatest { result ->
                when (result) {
                    is ResultWrapper.Success -> {
                        _tvShowsSuccess.emit(result.data?.toCollection(ArrayList()))
                    }

                    is ResultWrapper.Error -> {
                        _state.emit(
                            BaseViewState.Error(
                                result.error
                            )
                        )
                    }

                }
            }
    }

    fun shareData() {
        launchCoroutine(coroutineExceptionHandler) {
            _eventState.emit(HomeEventState.ShareDataBase)
        }
    }

}

