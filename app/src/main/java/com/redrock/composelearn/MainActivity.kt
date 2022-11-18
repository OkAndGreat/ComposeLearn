package com.redrock.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.redrock.composelearn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                Column {
                    WeBottomBar(0)
                }
            }
        }
    }

    @Composable
    private fun WeBottomBar(selected: Int) {
        Row(Modifier.background(Color.White)) {
            TabItem(
                if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
                "聊天", if (selected == 0) Color.Green else Color.Black, Modifier.weight(1f)
            )
            TabItem(
                if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
                "通讯录", if (selected == 1) Color.Green else Color.Black, Modifier.weight(1f)
            )
            TabItem(
                if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
                "发现", if (selected == 2) Color.Green else Color.Black, Modifier.weight(1f)
            )
            TabItem(
                if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
                "我", if (selected == 3) Color.Green else Color.Black,
                Modifier.weight(1f)
            )
        }
    }

    @Composable
    private fun TabItem(
        @DrawableRes iconId: Int,
        title: String,
        tint: Color,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(painterResource(iconId), title, Modifier.size(24.dp), tint = tint)
            Text(title, fontSize = 11.sp, color = tint)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun WeBottomBarPreView() {
        WeBottomBar(0)
    }

    @Preview(showBackground = true)
    @Composable
    fun TabItemPreview() {
        //MaterialTheme.colors 是CompositionLocal对象 可以和ThreadLocal 对比学习
        TabItem(R.drawable.ic_chat_outlined, "聊天", tint = MaterialTheme.colors.error)
    }
}
