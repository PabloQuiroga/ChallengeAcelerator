package com.siar.myappacelerator.ui.screens.first

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.myappacelerator.R
import com.siar.myappacelerator.data.model.UserModel

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 *
 * Since: 10/02/2024
 * Last update: 23/02/2024
 *
 * All rights reserved 2024.
 *****/
@Composable
fun FirstScreen(
    uiState: FirstUiState,
    onClick: (name: String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.teal_200)),
        contentAlignment = Alignment.Center
    ) {
        when(uiState){
            is FirstUiState.Loading -> {
                ShowLoader()
            }
            is FirstUiState.Error -> {
                ShowError(uiState.error)
            }

            is FirstUiState.Success -> {
                ShowSuccessContent(
                    userList = uiState.users,
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
fun ShowSuccessContent(
    userList: List<UserModel>,
    onClick: (name: String) -> Unit
){
    Text(
        text = "Click me for navigation!",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.clickable {
            onClick(userList[0].name)
        }
    )
}

@Composable
fun ShowLoader(){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator()
    }
}

@Composable
fun ShowError(message: String){
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = message,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowSuccessPreview(){
    ShowSuccessContent(userList = emptyList(), onClick = {})
}

@Preview(showBackground = true)
@Composable
fun ShowErrorPreview(){
    ShowError("Error de internet")
}

@Preview
@Composable
fun FirstScreenPreview(){
    FirstScreen(uiState = FirstUiState.Loading){}
}
