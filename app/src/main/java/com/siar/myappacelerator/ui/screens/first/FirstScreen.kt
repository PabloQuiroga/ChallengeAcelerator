package com.siar.myappacelerator.ui.screens.first

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.siar.myappacelerator.R
import com.siar.myappacelerator.domain.model.User
import com.siar.myappacelerator.ui.components.CustomTopBar
import com.siar.myappacelerator.ui.components.UserCard
import com.siar.myappacelerator.ui.theme.MyAppAceleratorTheme
import com.siar.myappacelerator.util.MockUser

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
    onItemClick: (User) -> Unit
) {
    Scaffold(
        topBar = {
            CustomTopBar(
                title = stringResource(id = R.string.app_name)
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentAlignment = Alignment.Center,
            ) {
                when (uiState) {
                    is FirstUiState.Loading -> {
                        ShowLoader()
                    }

                    is FirstUiState.Error -> {
                        ShowError(uiState.error)
                    }

                    is FirstUiState.Success -> {
                        ShowSuccessContent(
                            userList = uiState.users,
                            onItemClick = onItemClick
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun ShowSuccessContent(
    userList: List<User>,
    onItemClick: (User) -> Unit,
) {
    LazyColumn(
        content = {
            items(userList) {
                UserCard(
                    user = it,
                    onItemClick = onItemClick
                )
            }
        }
    )
}

@Composable
fun ShowLoader() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ShowError(message: String) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            modifier = Modifier.padding(top = 16.dp),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShowSuccessPreview() {
    MyAppAceleratorTheme(darkTheme = true) {
        ShowSuccessContent(
            userList = listOf(MockUser.mockUser),
            onItemClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowErrorPreview() {
    ShowError("Error de internet")
}

@Preview
@Composable
fun FirstScreenPreview() {
    MyAppAceleratorTheme {
        FirstScreen(uiState = FirstUiState.Loading) {}
    }
}
