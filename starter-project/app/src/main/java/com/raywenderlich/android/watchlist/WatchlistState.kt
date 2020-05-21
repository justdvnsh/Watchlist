package com.raywenderlich.android.watchlist

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class WatchlistState(val movies: Async<List<MovieModel>> = Uninitialized): MvRxState