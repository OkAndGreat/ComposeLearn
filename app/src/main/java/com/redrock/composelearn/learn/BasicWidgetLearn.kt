package com.redrock.composelearn.learn

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.redrock.composelearn.app

/**
 * Author by OkAndGreat
 * Date on 2022/11/18 18:01.
 *
 */

@Composable
@Preview
fun BasicWidget() {
    Column {
        Text("123", Modifier
            .clickable {
                Toast.makeText(app.appContext, "123", Toast.LENGTH_SHORT).show()
            }
            .fillMaxWidth()
            .padding(10.dp),
            textAlign = TextAlign.Center
        )

        Row(Modifier.fillMaxWidth()) {
            Text("1", Modifier.weight(1f))
            Text("2", Modifier.weight(1f))
            Text("3", Modifier.weight(1f))
            Text("4", Modifier.weight(1f))
        }

        val list = listOf("1", "2", "3", "4")

        LazyRow() {
            item {
                Text("添加单个Text", Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp))
            }

            items(list) {
                Text("第$it 个Item")
            }
        }

        LazyColumn(Modifier.fillMaxWidth()) {
            item {
                Text(
                    "我是Header",
                    Modifier
                        .background(Color.Red)
                        .fillMaxWidth()
                        .padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }

            itemsIndexed(list) { index, item ->
                Text("第$index 个Item，value = $item")
            }
        }
    }


}