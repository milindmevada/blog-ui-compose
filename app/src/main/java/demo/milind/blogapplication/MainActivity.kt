package demo.milind.blogapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import demo.milind.blogapplication.ui.theme.BlogApplicationTheme
import demo.milind.blogapplication.ui.theme.Blue
import demo.milind.blogapplication.ui.theme.BlueDarkText
import demo.milind.blogapplication.ui.theme.ScaffoldBackground

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogApplicationTheme {
                BlogDetailsScreen()
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun BlogDetailsScreen() {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            AppBar(isTitleVisible = scrollState.value > 10)
        },
        content = {
            Box(Modifier.fillMaxSize()) {
                Column {
                    BlogTitle()
                    Spacer(modifier = Modifier.height(32.dp))
                    AuthorTile()
                    Spacer(modifier = Modifier.height(24.dp))
                }
                BlogContent(scrollState)
                Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                    BottomOverLay(isLikeButtonVisible = scrollState.value == scrollState.maxValue)
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

@ExperimentalAnimationApi
@Composable
fun AppBar(isTitleVisible: Boolean) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_left),
            contentDescription = null,
            tint = BlueDarkText,
        )
        AnimatedVisibility(
            visible = isTitleVisible,
            modifier = Modifier.weight(1f),
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Text(
                "Four Things Every Women Needs to know",
                style = MaterialTheme.typography.h6,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_overflow),
            contentDescription = null,
            tint = BlueDarkText,
        )
    }
}

@Composable
fun BlogContent(scrollState: ScrollState) {
    val offset by animateDpAsState(targetValue = if (scrollState.value == 0) 150.dp else 0.dp)
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .offset(y = offset)
            .padding(bottom = 116.dp)
            .background(ScaffoldBackground)
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
            text = dummyBlogContent,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(horizontal = 28.dp)
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun BottomOverLay(isLikeButtonVisible: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .padding(horizontal = 24.dp)
            .background(
                Brush.verticalGradient(
                    0.0f to Color(0x00F9FAFF),
                    1.0f to Color(0xFFFAFBFF),
                )
            )

    ) {
        AnimatedVisibility(
            visible = isLikeButtonVisible,
            modifier = Modifier
                .align(Alignment.CenterEnd),
            enter = slideIn(initialOffset = { IntOffset(0, it.height) }),
            exit = slideOut(targetOffset = { IntOffset(0, it.height * 2) }),
        ) {
            LikeButton()
        }
    }
}

@Composable
fun LikeButton() {
    Box(
        modifier = Modifier
            .background(
                color = Blue,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 22.dp, vertical = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_thumb),
                contentDescription = null,
                tint = Color.White,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "2.1k",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun PreviewApp() {
    BlogDetailsScreen()
}