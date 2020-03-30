package com.example.exemplo1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview

val item = Item(
    "Flurp Minor", "Rápido e temivel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
            "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
            "dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.", "20/01/1993"
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = mutableListOf(item)

        val state = ScreenState(list)

        setContent {
            MaterialTheme {
                MyExampleFunction(state = state)
            }
        }
    }
}

@Composable
fun MyExampleFunction(state: ScreenState) {

    VerticalScroller {
        Column {
            Text(text = state.qtdItem.toString())

            Padding(padding = 10.dp) {
                FAV {state.list.add(item)
                    state.qtdItem = state.list.size
                    Log.d("gustavot", state.list.size.toString())
                }
            }

            for (item in state.list) {
                Padding(16.dp) {
                    NewsStory(item = item)
                }
            }
        }
    }
}

@Composable
fun NewsStory(item: Item) {
    val image = +imageResource(R.drawable.cat)
    MaterialTheme {
        Surface(shape = RoundedCornerShape(8.dp), elevation = 8.dp) {

            Column(
                modifier = Spacing(16.dp)
            ) {

                Text(
                    text = item.name,
                    style = TextStyle(
                        fontStyle = FontStyle.Normal,
                        fontFamily = FontFamily.Cursive,
                        fontSize = 50.sp
                    )
                )


                Container(modifier = Height(180.dp) wraps Expanded) {
                    Clip(shape = RoundedCornerShape(8.dp)) {
                        DrawImage(image)
                    }
                }

                HeightSpacer(16.dp)
                Text(
                    text = item.history,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )

                HeightSpacer(10.dp)
                Divider(modifier = Height(1.dp), color = Color.Black)
                HeightSpacer(10.dp)

                Text(text = item.description)

                HeightSpacer(10.dp)
                Divider(modifier = Height(1.dp), color = Color.Black)
                HeightSpacer(10.dp)

                Text(text = item.date, style = TextStyle(fontFamily = FontFamily.Monospace))

                Padding(padding = 5.dp) {

                    Button(text = "INFO", style = OutlinedButtonStyle())
                }

            }
        }
    }
}

@Composable
fun FAV(event: () -> Unit) {
    Row {
            Button(text = "Adicionar",
                style = OutlinedButtonStyle(),
                onClick = event)

    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        NewsStory(Item("teste", "teste", "tete", "19/01/1993"))
    }
}