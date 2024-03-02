package com.siar.myappacelerator.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.siar.myappacelerator.R

/*****
 * Project: My App Acelerator
 * Created by: Pablo Daniel Quiroga
 * Last update: 28/02/2024
 *
 *****/
@Composable
fun CustomTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.image_size))
                .padding(dimensionResource(id = R.dimen.padding_small)),
            painter = painterResource(R.drawable.q_icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun CustomTopBarPreview(){
    CustomTopBar()
}
