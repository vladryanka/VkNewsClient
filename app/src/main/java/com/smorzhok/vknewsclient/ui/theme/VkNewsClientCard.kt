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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smorzhok.vknewsclient.R

@Composable
fun VkNewsClientCard() {
    Card(Modifier.padding(4.dp)) {
        PostHeader()
        Text(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            color = MaterialTheme.colorScheme.onPrimary,
            text = stringResource(R.string.template_text)
        )
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Statistics()
    }
}

@Composable
fun Statistics() {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(R.drawable.ic_eye), contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = "206", color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "206", color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Icon(
            painterResource(R.drawable.ic_arrow_outward), contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = "11", color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Icon(
            painterResource(R.drawable.comment), contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = "491", color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
        Icon(
            painter = painterResource(R.drawable.favorite), contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun PostHeader() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
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
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary
        )
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

