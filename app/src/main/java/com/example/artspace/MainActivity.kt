package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var artistOrder by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Coloquei um spacer para a img sair do topo e ir p/ o centro
        Spacer(modifier = Modifier.height(2.dp))
        when(artistOrder) {
            1 -> {
                Picture(
                    modifier = Modifier,
                    drawableResourceId = R.drawable.abaporu,
                    contentDescriptionResourceId = R.string.ababoru
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ArtistInfo(
                        modifier = Modifier,
                        artworkTitleId = R.string.ababoru,
                        artworkArtistId = R.string.tarsila_do_amaral_1928
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    NextAndPreviousButton(
                        modifier = Modifier,
                        onClickNext = { artistOrder++ },
                        onClickPrevious = {  }
                    )
                }
            }
            2 -> {
                Picture(
                    modifier = Modifier,
                    drawableResourceId = R.drawable.operarios,
                    contentDescriptionResourceId = R.string.operarios
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ArtistInfo(
                        modifier = Modifier,
                        artworkTitleId = R.string.operarios,
                        artworkArtistId = R.string.tarsila_do_amaral_1933
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    NextAndPreviousButton(
                        modifier = Modifier,
                        onClickNext = { artistOrder++ },
                        onClickPrevious = { artistOrder-- }
                    )
                }
            }
            3 -> {
                Picture(
                    modifier = Modifier,
                    drawableResourceId = R.drawable.la_rentree,
                    contentDescriptionResourceId = R.string.la_rentree
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ArtistInfo(
                        modifier = Modifier,
                        artworkTitleId = R.string.la_rentree,
                        artworkArtistId = R.string.anita_malfatti
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    NextAndPreviousButton(
                        modifier = Modifier,
                        onClickNext = { artistOrder++ },
                        onClickPrevious = { artistOrder-- }
                    )
                }
            }
            4 -> {
                Picture(
                    modifier = Modifier,
                    drawableResourceId = R.drawable.o_lavrador_de_cafe,
                    contentDescriptionResourceId = R.string.o_lavrador_de_cafe
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ArtistInfo(
                        modifier = Modifier,
                        artworkTitleId = R.string.o_lavrador_de_cafe,
                        artworkArtistId = R.string.candido_portinari
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    NextAndPreviousButton(
                        modifier = Modifier,
                        onClickNext = { artistOrder++ },
                        onClickPrevious = { artistOrder-- }
                    )
                }
            }
            else -> {
                Picture(
                    modifier = Modifier,
                    drawableResourceId = R.drawable.samba,
                    contentDescriptionResourceId = R.string.samba
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    ArtistInfo(
                        modifier = Modifier,
                        artworkTitleId = R.string.samba,
                        artworkArtistId = R.string.di_cavalcanti
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    NextAndPreviousButton(
                        modifier = Modifier,
                        onClickNext = {  },
                        onClickPrevious = { artistOrder-- }
                    )
                }
            }

        }

    }
}

@Composable
fun Picture(
    modifier: Modifier,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int
) {
    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.border(
            width = 4.dp,
            shape = RoundedCornerShape(5.dp),
            color = Color.Gray
        )
    ) {
        Column(Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(drawableResourceId),
                contentDescription = stringResource(contentDescriptionResourceId),
                modifier = Modifier
                    .padding(32.dp)
            )
        }
    }
}

@Composable
fun ArtistInfo(
    modifier: Modifier,
    artworkTitleId: Int,
    artworkArtistId: Int
) {
    Card(
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(artworkTitleId),
                fontSize = 28.sp,
                fontWeight = FontWeight.Light
            )
            Text(
                stringResource(artworkArtistId),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun NextAndPreviousButton(
    modifier: Modifier,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick =  onClickPrevious,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp, end = 8.dp)
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = onClickNext,
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp, start = 8.dp)
        ) {
            Text("Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}