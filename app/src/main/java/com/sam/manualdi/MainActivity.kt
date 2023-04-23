package com.sam.manualdi

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sam.manualdi.model.FreeTip
import com.sam.manualdi.ui.MainViewModel
import com.sam.manualdi.ui.theme.ManualDiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManualDiTheme {
                Column {
                    val viewModel:MainViewModel  = viewModel(factory = MainViewModel.factory)
                    MyScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun MyScreen(viewModel: MainViewModel) {
    val freeTips = viewModel.freeTips.collectAsStateWithLifecycle().value
    LazyColumn{
        items(freeTips){
            FreeTips(freeTip = it)
        }
    }
}



@Composable
fun FreeTips(freeTip:FreeTip){
    Text(text = freeTip.match)
}