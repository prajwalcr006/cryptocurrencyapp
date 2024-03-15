package com.example.cryptocurrencyapp.presentation.coin_detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.common.constants
import com.example.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class CoinDetailViewModel @Inject constructor(private val getCoinUseCase: GetCoinUseCase,
                                              savedStateHandle: SavedStateHandle): ViewModel() {

    private val _state = MutableLiveData<CoinDetailState>()
    val state = _state

    init {
        savedStateHandle.get<String>(constants.COIN_ID)?.let { coinId ->
            getCoinDetails(coinId)
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getCoinDetails(coinId: String) {

        getCoinUseCase(coinId).onEach {result->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinDetails = result.data)
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(loading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message?: "error at coinDetail viewModel")
                }
            }

        }.launchIn(viewModelScope)
    }

}