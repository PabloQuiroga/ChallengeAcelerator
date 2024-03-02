package com.siar.myappacelerator.ui.screens.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.siar.myappacelerator.R
import com.siar.myappacelerator.domain.model.User
import com.siar.myappacelerator.ui.components.CustomTopBar

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 10/02/2024
 *
 *****/
@Suppress("UnusedPrivateProperty") //only for demo DataStore
@Composable
fun SecondScreen(
    viewModel: SecondViewModel,
    user: User,
    onBackClick: () -> Unit
) {
    val preferenceName = viewModel.userName.collectAsState()

    Scaffold(
        topBar = {
            CustomTopBar(
                title = stringResource(id = R.string.title_details),
                backIcon = true,
                onBackClick = onBackClick
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .background(color = colorResource(id = R.color.teal_200)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hola ${user.name}!",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    )

}
