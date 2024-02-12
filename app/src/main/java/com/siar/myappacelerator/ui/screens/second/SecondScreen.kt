package com.siar.myappacelerator.ui.screens.second

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.siar.myappacelerator.R
import com.siar.myappacelerator.ui.screens.first.FirstViewModel

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 10/02/2024
 *
 *****/
@Composable
fun SecondScreen(name: String) {

    val viewModel: SecondViewModel = hiltViewModel()
    val isLoading = viewModel.isLoading.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.teal_200)),
        contentAlignment = Alignment.Center
    ) {
        ShowContent(enabled = isLoading.value, name = name)
    }
}

@Composable
fun ShowContent(enabled: Boolean, name: String) {
    if (enabled) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Text(
            text = "Hola $name!",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun SecondScreenPreview(){
    //SecondScreen("Pablo", )
}