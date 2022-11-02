package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
        Picture(modifier = Modifier)
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ArtistInfo(modifier = Modifier)
            Spacer(modifier = Modifier.height(16.dp))
            NextAndPreviousButton(modifier = Modifier)
            
        }


    }

}

@Composable
fun Picture(
    modifier: Modifier = Modifier
) {
    Box {
        Spacer(modifier = Modifier
            .matchParentSize()
            .border(
                width = 2.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(5.dp)
            )
        )
        Image(
            painter = painterResource(R.drawable.original),
            contentDescription = "Exemplo",
            modifier = Modifier
                .padding(24.dp)
        )
    }
}

@Composable
fun ArtistInfo(modifier: Modifier) {
    Column(
    ) {
        Text("Artwork Title", fontSize = 24.sp)
        Text("Artwork Artist (year)")
    }
}

@Composable
fun NextAndPreviousButton(modifier: Modifier){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp, end = 8.dp)
        ) {
            Text(text = "Previous")
        }
        Button(onClick = { /*TODO*/ },
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