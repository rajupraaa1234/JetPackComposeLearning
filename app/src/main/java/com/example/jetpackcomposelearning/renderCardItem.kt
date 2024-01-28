package com.example.jetpackcomposelearning

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(heightDp = 300)
@Composable
fun DisplayItem() {
    //RenderItem(androidx.core.R.drawable.ic_call_decline, "Software Developer", "Raju kumar")
//    Column(modifier = Modifier.verticalScroll(rememberScrollState() )) {   (all Item Will render at a time)
//        getBatchData().map { item->
//             RenderItem(Img = item.Img, title = item.Degignation, name = item.name)
//        }
//    }

    LazyColumn(content = {            // Like RecyclerView  (Only visible Item Will render)
        items(getBatchData()) { item ->
            RenderItem(Img = item.Img, title = item.Degignation, name = item.name)
        }
    })
}

@Composable
fun RenderItem(Img: Int, title: String, name: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(id = Img),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(3f)
            )
            titleWithName(title, name, Modifier.Companion.weight(7f))

        }

    }
}

@Composable
private fun titleWithName(title: String, name: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = name,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

data class Batch(val Img: Int, val name: String, val Degignation: String);

fun getBatchData(): MutableList<Batch> {
    val list = mutableListOf<Batch>();

    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Raju kumar", "Software Developer"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Raja kumar", "Software Developer"));

    list.add(
        Batch(
            androidx.core.R.drawable.ic_call_decline,
            "Rahul kumar",
            "Software Developer I"
        )
    );
    list.add(
        Batch(
            androidx.core.R.drawable.ic_call_decline,
            "Rakesh kumar",
            "Software Developer II"
        )
    );
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Ram kumar", "Software Developer I"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Akash kumar", "Manager"));
    list.add(
        Batch(
            androidx.core.R.drawable.ic_call_decline,
            "Rockey kumar",
            "Full Stack Developer"
        )
    );
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Aman kumar", "HR"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Hemanth kumar", "Android Developer"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Sanju kumari", "Backend Developer"));
    list.add(
        Batch(
            androidx.core.R.drawable.ic_call_decline,
            "Rajesh kumar Gupta",
            "Software Developer"
        )
    );
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Ram kumar", "Software Developer I"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Akash kumar", "Manager"));
    list.add(
        Batch(
            androidx.core.R.drawable.ic_call_decline,
            "Rockey kumar",
            "Full Stack Developer"
        )
    );
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Aman kumar", "HR"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Hemanth kumar", "Android Developer"));
    list.add(Batch(androidx.core.R.drawable.ic_call_decline, "Sanju kumari", "Backend Developer"));
    list.add(
        Batch(
            androidx.core.R.drawable.ic_call_decline,
            "Rajesh kumar Gupta",
            "Software Developer"
        )
    );
    return list;
}