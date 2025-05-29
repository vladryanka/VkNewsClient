package com.smorzhok.vknewsclient.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smorzhok.vknewsclient.R

@Composable
fun VkNewsClientCard() {
    Card(Modifier.padding(4.dp)) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Уволено", color = MaterialTheme.colorScheme.onPrimary)
                Text(text = "14:00", color = MaterialTheme.colorScheme.onSecondary)
            }
            Icon(
                imageVector = Icons.Rounded.MoreVert,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.onPrimary,
            text = "Кабаныч, когда узнал, что если сотрудникам не платить они начинают умирать от голода"
        )
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(modifier = Modifier.padding(8.dp)) {
            Text(text = "206", color = MaterialTheme.colorScheme.onSecondary)
            Icon(Icons.Rounded.AccountCircle, contentDescription = "")
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Text(text = "206", color = MaterialTheme.colorScheme.onSecondary)
            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "")
            Text(text = "11", color = MaterialTheme.colorScheme.onSecondary)
            Icon(imageVector = Icons.Rounded.Face, contentDescription = "")
            Text(text = "491", color = MaterialTheme.colorScheme.onSecondary)
            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "")
        }
    }
}


@Preview
@Composable
fun PreviewCardLight() {
    VkNewsClientTheme(darkTheme = false) {
        VkNewsClientCard()
    }
}

@Preview
@Composable
fun PreviewCardDark() {
    VkNewsClientTheme(darkTheme = true) {
        VkNewsClientCard()
    }
}

