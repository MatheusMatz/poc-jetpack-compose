//package com.example.exemplo1
//
//import android.graphics.drawable.PaintDrawable
//import android.util.Log
//import android.widget.Toast
//import androidx.compose.Composable
//import androidx.compose.unaryPlus
//import androidx.ui.core.Text
//import androidx.ui.core.dp
//import androidx.ui.layout.Height
//import androidx.ui.layout.Row
//import androidx.ui.material.AppBarIcon
//import androidx.ui.material.TopAppBar
//import androidx.ui.res.imageResource
//import androidx.ui.tooling.preview.Preview
//
//@Preview
//@Composable
//fun TopBar() {
//    TopAppBar(
//        navigationIcon = {
//            AppBarIcon(
//                PaintDrawable(R.drawable.ic_baseline_menu_24)
//            ) { /* do something here */ }
//        },
//        title = { Text(text = "Jetpack Compose") },
//        actionData = listOf(
//            imageResource(R.drawable.ic_baseline_share_24)
//        )
//    )
//    { actionImage ->
//        AppBarIcon(actionImage) { /* do something here */ }
//    }
//}