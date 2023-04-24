package com.sam.manualdi.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sam.manualdi.R
import com.sam.manualdi.ui.theme.ManualDiTheme
import com.sam.manualdi.util.smallPadding

@Composable
fun SingleGameCard(
    modifier: Modifier = Modifier,
    leagueName: String,
    homeGame: String,
    awayGame: String,
    outcome: String,
    time:String
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.extraSmall,
        color = MaterialTheme.colorScheme.surface.copy(
            alpha = 0.7f
        )
    ) {
        Column {
            LeagueSection(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.surface.copy(
                            alpha = 0.2f
                        )
                    ),
                icon = R.drawable.ic_flag,
                leagueName = leagueName,
                gameTime = time
            )
            GameSection(
                modifier = Modifier.smallPadding(),
                homeGame = homeGame,
                awayGame = awayGame
            )
            Outcome(
                modifier = Modifier.smallPadding(),
                outcome = outcome
            )
        }
    }
}


@Composable
fun LeagueSection(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    leagueName: String,
    gameTime: String
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment =  Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
                Text(
                    text = leagueName,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 14.sp
                    )
                )
            }
            Text(
                text = gameTime,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Composable
fun GameSection(
    modifier: Modifier = Modifier,
    homeGame: String,
    awayGame: String
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = homeGame,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp
            )
        )
        Text(
            text = "vs",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp
            )
        )
        Text(
            text = awayGame,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun Outcome(modifier: Modifier = Modifier, outcome: String) {
    Surface(
        modifier = modifier,
        color = Color.Blue.copy(alpha = 0.2f),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = outcome,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp
            )
        )
    }
}

