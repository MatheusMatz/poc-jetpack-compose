package com.example.exemplo1

import androidx.compose.Model

@Model
data class ScreenState (var list: MutableList<Item>, var qtdItem: Int = list.size)