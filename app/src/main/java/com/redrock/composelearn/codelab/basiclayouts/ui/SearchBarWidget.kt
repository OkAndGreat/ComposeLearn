package com.redrock.composelearn.codelab.basiclayouts.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 11:26.
 * 标准写法
 * 提供一个有状态+无状态 复用性高
 * preview中使用有状态的Widget
 */

@Composable
fun SearchBarStatefulWidget( modifier: Modifier = Modifier) {
    //使用viewmodel更好
    //使用rememberSaveable相比较与remember可以在旋转屏幕时保存数据
    val searchBarText = rememberSaveable { mutableStateOf("") }
    SearchBarStatelessWidget(modifier,onValueChange = { searchBarText.value = it }, value = searchBarText.value)
}

@Composable
fun SearchBarStatelessWidget(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    value: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text("search")
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Preview
@Composable
fun SearchBarWidgetPreview() {
    SearchBarStatefulWidget()
}