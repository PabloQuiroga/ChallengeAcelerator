package com.siar.myappacelerator.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.siar.myappacelerator.R
import com.siar.myappacelerator.domain.model.User
import com.siar.myappacelerator.util.MockUser

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 26/02/2024
 *
 *****/
@Composable
fun UserCard(
    user: User,
    onItemClick: (User) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onItemClick(user)
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.creamy_green),
            contentColor = colorResource(id = R.color.purple_700)
        ),
        border = BorderStroke(
            5.dp,
            colorResource(id = R.color.purple_700)
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {//only for demo behind construction
            Text(
                text = user.name,
            )
            Text(
                text = user.name,
            )
            Text(
                text = user.name,
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun UserCardPreview(){
    UserCard(
        user = MockUser.mockUser
    ){
        Log.e("Clickable", MockUser.mockUser.toString())
    }
}
