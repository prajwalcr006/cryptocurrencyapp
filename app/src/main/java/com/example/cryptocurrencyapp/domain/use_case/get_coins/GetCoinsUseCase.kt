package com.example.cryptocurrencyapp.domain.use_case.get_coins

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.CoinDto
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.flow
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//This is logic to get all coins from api
class GetCoinsUseCase @Inject constructor(private val coinRepository: CoinRepository) {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {
            emit(Resource.Loading())
            val data = coinRepository.getCoins().map { it.toCoin() }
            emit(Resource.Success(data))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:"unexpected message!!!"))
        } catch (e: IOException) {
            emit(Resource.Error("Cannot call api, Check internet!!!"))
        }
    }
}