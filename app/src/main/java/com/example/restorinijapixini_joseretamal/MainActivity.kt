package com.example.restorinijapixini_joseretamal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.restorinijapixini_joseretamal.ui.theme.RestoriniJapixini_JoseRetamalTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard("Android", "Keloke mi loco")
                }
            }
        }
    }
}
data class Message(val author: String, val body: String)
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = "Contacto perfil pintura",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = msg.body)
        }
    }
}
@Composable
fun MessageCard(name: String) {
    Text(text = "Hello $name!")
}
@Preview
@Composable
fun PreviewMessageCard() {
    ComposeTutorialTheme {
        surface {
            MessageCard(
                msg = Messege("oye mi loco como termine aca tu sabe")
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestoriniJapixini_JoseRetamalTheme {
        Greeting("Android")
    }
}