package com.siar.myappacelerator.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.siar.myappacelerator.R
import com.siar.myappacelerator.domain.model.User
import com.siar.myappacelerator.ui.theme.MyAppAceleratorTheme
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
            .padding(dimensionResource(id = R.dimen.padding_small))
            .clickable {
                onItemClick(user)
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp
        ),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.creamy_green),
            contentColor = colorResource(id = R.color.purple_700)
        ),
        border = BorderStroke(
            2.dp,
            colorResource(id = R.color.purple_700)
        )
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clip(shape = MaterialTheme.shapes.small),
                painter = painterResource(id = R.drawable.q_icon),
                contentDescription = "user image",
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small)),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small)),
                    text = user.name,
                    style = MaterialTheme.typography.displayMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = user.phone,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserCardLightPreview(){
    MyAppAceleratorTheme{
        UserCard(
            user = MockUser.mockUser
        ){
            Log.e("Clickable", MockUser.mockUser.toString())
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun UserCardDarkPreview(){
    MyAppAceleratorTheme(darkTheme = true) {
        UserCard(
            user = MockUser.mockUser
        ){
            Log.e("Clickable", MockUser.mockUser.toString())
        }
    }
}
