package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val images = listOf(
        R.drawable.artwork1,
        R.drawable.artwork2,
        R.drawable.artwork3
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(images[currentIndex]),
            contentDescription = "Artwork",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Beragam Lukisan", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Artist: Raden Saleh", fontSize = 16.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Nama: Wulan Kinasih",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "NIM: 225411002",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = {
                currentIndex = if (currentIndex > 0) currentIndex - 1 else images.size - 1
            }) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                currentIndex = (currentIndex + 1) % images.size
            }) {
                Text(text = "Next")
            }
        }
    }
}
