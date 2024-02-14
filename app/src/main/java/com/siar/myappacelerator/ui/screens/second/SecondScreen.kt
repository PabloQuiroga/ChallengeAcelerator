package com.siar.myappacelerator.ui.screens.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.siar.myappacelerator.R

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 10/02/2024
 *
 *****/
@Suppress("UnusedParameter") //only for demo DataStore
@Composable
fun SecondScreen(
    viewModel: SecondViewModel,
    name: String
) {
    val preferenceName = viewModel.userName.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.teal_200)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hola ${preferenceName.value}!",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
