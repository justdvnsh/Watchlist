package com.raywenderlich.android.watchlist

import com.airbnb.mvrx.*

class WatchlistViewModel(
        initialState: WatchlistState,
        private val watchlistRepository: WatchlistRepository
) : BaseMvRxViewModel<WatchlistState>(initialState, debugMode = true) {

    init {
        setState {
            copy(movies = Loading())
        }

        watchlistRepository.getWatchlistedMovies().execute {
            copy(movies = it)
        }
    }

    companion object: MvRxViewModelFactory<WatchlistViewModel, WatchlistState> {

        override fun create(viewModelContext: ViewModelContext, state: WatchlistState): WatchlistViewModel? {
            val watchlistRepository = viewModelContext.app<WatchlistApp>().watchlistRepository
            return WatchlistViewModel(state, watchlistRepository)
        }
    }



}