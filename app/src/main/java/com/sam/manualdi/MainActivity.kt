package com.sam.manualdi

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sam.manualdi.model.FreeTip
import com.sam.manualdi.ui.MainViewModel
import com.sam.manualdi.ui.components.SingleGameCard
import com.sam.manualdi.ui.theme.ManualDiTheme
import com.sam.manualdi.util.getOutcome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManualDiTheme {
                Column {
                    val viewModel: MainViewModel = viewModel(factory = MainViewModel.factory)
                    val state = viewModel.uiState.collectAsStateWithLifecycle().value
                    MyScreen(state)
                }
            }
        }
    }
}

@Composable
fun MyScreen(
    state: UiState
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (state.loading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = 4.dp,
                vertical = 4.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.data) {
                val homeGame = it.match.split("vs")[0]
                val awayGame = it.match.split("vs")[1]
                val time = it.time.split(" ")[2]
                SingleGameCard(
                    leagueName = it.league,
                    homeGame = homeGame,
                    awayGame = awayGame,
                    outcome = it.outcome.getOutcome(),
                    time = time
                )
            }
        }
    }
}

