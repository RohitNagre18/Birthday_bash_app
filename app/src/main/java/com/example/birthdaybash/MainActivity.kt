package com.example.birthdaybash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaybash.ui.theme.BirthdaybashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdaybashTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingImage(message = "Happy Birthday John", from = "-from Emma")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingImage(message: String,from:String){
    val image = painterResource(id = R.drawable.android)
    androidx.compose.foundation.Image(painter = image, 
        contentDescription =null,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    BirthdayGreetingImage(message = message, from = from)
}
@Composable
fun BirthdayGreetingText(message: String,from:String){
    Column {
        Text(text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start =16.dp,top = 16.dp)
        )
        Text(text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start =16.dp,top = 16.dp)
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BirthdayGreetingImagePreview() {
    BirthdaybashTheme {
        BirthdayGreetingImage(message = "Happy Birthday John", from = "-from Emma")
    }
}