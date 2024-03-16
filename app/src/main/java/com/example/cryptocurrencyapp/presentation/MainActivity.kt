package com.example.cryptocurrencyapp.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrencyapp.R
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.di.appModule
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.presentation.coin_list.CoinListViewModel
import com.example.cryptocurrencyapp.presentation.theme.CryptocurrencyappTheme
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import javax.inject.Inject


class MainActivity : ComponentActivity() {

    private val coinListViewModel:CoinListViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: List<Coin>
    private lateinit var adapter:AdopterClass

    private var dummyList: List<Coin> = listOf(
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),
        Coin("1","Bitcoin","BTC",1,true),


    )

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        adapter = AdopterClass(dummyList)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        dataList = arrayListOf<Coin>()

        observeViewModel()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun observeViewModel() {

        coinListViewModel.coinState.observe(this, {state->
            adapter.updateData(state.coins)
           // Log.d("check",state.coins.toString());
        })


    }
}

