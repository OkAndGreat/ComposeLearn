package com.redrock.composelearn.codelab.basiccodelab

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Author by OkAndGreat
 * Date on 2022/11/23 22:00.
 *
 */

data class Names(val name: String) {
    var expanded by mutableStateOf(false)
}

@Composable
fun RealContentScreen(
    modifier: Modifier = Modifier,
    names: List<Names> = List(1000) { Names("$it") },
    onItemClicked: (Int, List<Names>) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(4.dp)) {
        itemsIndexed(names) { index, item ->
            CardWidget(
                Modifier.padding(12.dp).background(MaterialTheme.colors.primary),
                names[index].expanded,
                onIconClicked = { onItemClicked(index, names) },
                names[index].name
            )
        }
    }
}

@Composable
fun CardWidget(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onIconClicked: () -> Unit,
    name: String
) {
    Row(
        modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            )
        )
    ) {
        Column(
            modifier = Modifier
                //weight 占据剩余空间
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name, fontWeight = FontWeight.W800
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }

        }

        IconButton(onClick = onIconClicked) {
            Icon(
                imageVector = if (expanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                contentDescription = null
            )
        }
    }
}