package com.example.lemonsqueezer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonsqueezer.ui.theme.LemonSqueezerTheme
import kotlin.math.round

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonSqueezerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {

    var steps by remember { mutableStateOf(1) }
    var squeezLemonCount by remember { mutableStateOf(0) }

    Surface (modifier = Modifier.fillMaxSize(),       //surface holds together different parts of the UI, such as app bars and floating action buttons, giving apps a coherent look and feel.
        color = MaterialTheme.colorScheme.background){

        when (steps) {
            1 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()

                ) {

                    Image(
                        painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = stringResource(
                            id = R.string.lemonTree
                        ),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { steps = 2
                            squeezLemonCount = (2..4).random()}
                            .border(2.dp, Color(red = 105, green = 205, blue = 216),
                                shape = CutCornerShape(4.dp),
                            )

                            .padding(10.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.tapTree),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold

                    )

                }
            }
            2 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()

                ){
                    Image(
                        painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = stringResource(
                            id = R.string.lemon
                        ),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { squeezLemonCount--
                                if (squeezLemonCount==0){
                                    steps=3}
                            }
                            .border(2.dp, Color(red = 105, green = 205, blue = 216),
                            shape = CutCornerShape(4.dp),
                        )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.tapLemon),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
            }
            3 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()

                ){
                    Image(
                        painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = stringResource(
                            id = R.string.glassOfLemonade
                        ),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { steps = 4 }
                            .border(2.dp, Color(red = 105, green = 205, blue = 216),
                                shape = CutCornerShape(4.dp),
                            )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.lemonade),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                        )
                }

            }
            4 -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement =  Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()

                ){
                    Image(
                        painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = stringResource(
                            id = R.string.emptyGlass
                        ),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { steps = 1 }
                            .border(2.dp, Color(red = 105, green = 205, blue = 216),
                                shape = CutCornerShape(4.dp),
                            )
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.tapEmptyGlass),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                        )
                }
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HelloThere() {
    LemonSqueezerTheme {
        LemonadeApp()
    }
}