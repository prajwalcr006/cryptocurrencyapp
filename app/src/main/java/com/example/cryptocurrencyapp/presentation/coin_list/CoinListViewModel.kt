package com.example.cryptocurrencyapp.presentation.coin_list

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase): ViewModel(){

    private val _state = MutableLiveData<CoinListState>()
    val coinState: LiveData<CoinListState> = _state

    init {
        getCoins()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCoins() {
        val list = getCoinsUseCase()

        list.onEach { result->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(loading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message?:"error at CoinListViewModel")
                }
            }

        }.launchIn(viewModelScope)
    }
}