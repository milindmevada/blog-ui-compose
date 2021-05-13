package demo.milind.blogapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import demo.milind.blogapplication.ui.theme.BlogApplicationTheme
import demo.milind.blogapplication.ui.theme.Blue
import demo.milind.blogapplication.ui.theme.BlueDarkText

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogApplicationTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Scaffold(
        topBar = {
            AppBar()
        },
        content = {
            Box {
                Column {
                    BlogTitle()
                    Spacer(modifier = Modifier.height(24.dp))
                    AuthorTile()
                    Spacer(modifier = Modifier.height(18.dp))
                    BlogContent()
                }
            }
        }
    )
}

@Composable
fun BlogTitle() {
    Text(
        text = "Four Things Every Woman Needs To Know",
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(horizontal = 28.dp),
        overflow = TextOverflow.Ellipsis,
        maxLines = 2
    )
}


@Composable
fun AuthorTile() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 28.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Richard Gervain",
                style = MaterialTheme.typography.body1,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "2m ago",
                style = MaterialTheme.typography.caption,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = null,
            tint = Blue,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_bookmark),
            contentDescription = null,
            tint = Blue,
        )
    }
}

@Composable
fun AppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_left),
            contentDescription = null,
            tint = BlueDarkText,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_overflow),
            contentDescription = null,
            tint = BlueDarkText,
        )
    }
}

@Composable
fun BlogContent() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .height(219.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    ),
                ),
            painter = painterResource(id = R.drawable.blog_image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "A man’s sexuality is never your mind responsibility.",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(horizontal = 28.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "This one got an incredible amount of backlash the last time I said it, so I’m going to say it again: a man’s sexuality is never, ever your responsibility, under any circumstances. Whether it’s the fifth date or your twentieth year of marriage, the correct determining factor for whether or not you have sex with your partner isn’t whether you ought to “take care of him” or “put out” because it’s been a while or he’s really horny — the correct determining factor for whether or not you have sex is whether or not you want to have sex.\n This one got an incredible amount of backlash the last time I said it, so I’m going to say it again: a man’s sexuality is never, ever your responsibility, under any circumstances. Whether it’s the fifth date or your twentieth year of marriage, the correct determining factor for whether or not you have sex with your partner isn’t whether you ought to “take care of him” or “put out” because it’s been a while or he’s really horny — the correct determining factor for whether or not you have sex is whether or not you want to have sex.\n",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(horizontal = 28.dp)
        )
    }
}

@Preview
@Composable
fun PreviewApp() {
    Greeting()
}