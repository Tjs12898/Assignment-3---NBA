package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment3.ui.theme.Assignment3Theme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment3.data.Datasource
import com.example.assignment3.model.NBATeams
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   NBATeamsApp()
                }
            }
        }
    }
}

@Composable
fun NBATeamsApp() {
    NBATeamsList(
        nbaTeamsList = Datasource().loadDataSource(),
    )
}

@Composable
fun NBATeamsList(nbaTeamsList: List<NBATeams>, modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(width = 120.dp, height = 70.dp),
                painter = painterResource(id = R.drawable.nba),
                contentDescription = "NBA"
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 70.dp)
        ) {
            items(nbaTeamsList) { nbaTeams ->
                NBATeamsCard(
                    nbaTeams = nbaTeams,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun NBATeamsCard(nbaTeams: NBATeams, modifier: Modifier = Modifier) {
    // Define states to track visibility of text
    var isDayTextVisible by remember { mutableStateOf(true) }
    var isTeamTextVisible by remember { mutableStateOf(true) }



    Card(modifier = modifier) {
        Column {
            // Button to toggle day text visibility
            // Conditional text based on day text visibility state
            if (isDayTextVisible) {
                Text(
                    text = LocalContext.current.getString(nbaTeams.stringResourceIdDay),
                    modifier = Modifier.padding(20.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Image(
                painter = painterResource(nbaTeams.imageResourceId),
                contentDescription = stringResource(nbaTeams.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )

            // Button to toggle team text visibility
            NBAButton(
                expanded = isTeamTextVisible,
                onClick = { isTeamTextVisible = !isTeamTextVisible },
                modifier = Modifier.padding(8.dp)
            )

            // Conditional text based on team text visibility state
            if (isTeamTextVisible) {
                Text(
                    text = LocalContext.current.getString(nbaTeams.stringResourceId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
private fun NBAButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview
@Composable
private fun NBATeamsCardPreview() {
    NBATeamsCard(NBATeams(R.string.Day1,R.string.trailblazers, R.drawable.sacramentokings))
}
