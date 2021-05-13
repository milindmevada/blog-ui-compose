package demo.milind.blogapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import demo.milind.blogapplication.ui.theme.BlogApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Hello H5!", style = MaterialTheme.typography.h5)
        Text(text = "Hello H6!", style = MaterialTheme.typography.h6)
        Text(text = "Hello Body1!", style = MaterialTheme.typography.body1)
        Text(text = "Hello Body2!", style = MaterialTheme.typography.body2)
        Text(text = "Hello Caption!", style = MaterialTheme.typography.caption)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BlogApplicationTheme {
        Greeting("Android")
    }
}