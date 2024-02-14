package com.siar.myappacelerator.ui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
 * Since: 10/02/2024
 *
 * All rights reserved 2024.
 *****/
@Composable
fun FirstScreen(
    viewModel: FirstViewModel,
    onClick: (name: String) -> Unit
) {
    val isLoading = viewModel.isLoading.collectAsState()
    val users = viewModel.usersList.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.teal_200)),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading.value){
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }else {
            Text(
                text = "Click me for navigation!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    viewModel.onTextClicked()
                }
            )
        }

        LaunchedEffect(key1 = users.value){
            if(users.value.isNotEmpty()){
                onClick(users.value[0].name)
            }
        }
    }
}