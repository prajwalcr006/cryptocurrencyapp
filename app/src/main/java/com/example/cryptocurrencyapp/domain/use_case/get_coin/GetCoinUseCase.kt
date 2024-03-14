package com.example.cryptocurrencyapp.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyapp.domain.model.CoinDetails
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId: String): Flow<Resource<List<CoinDetails>>> = flow {
        try {
            emit(Resource.Loading())
            val data = coinRepository.getCoinById(coinId).map { it.toCoinDetail() }
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:"unexpected error!!!"))
        } catch (e: IOException) {
            emit(Resource.Error("Cannot call api, Check internet!!!"))
        }
    }
}