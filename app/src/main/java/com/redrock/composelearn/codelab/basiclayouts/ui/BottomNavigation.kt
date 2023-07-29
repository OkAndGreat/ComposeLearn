package com.redrock.composelearn.codelab.basiclayouts.ui

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.redrock.composelearn.R

/**
 * Author by OkAndGreat
 * Date on 2022/11/24 14:26.
 *
 */

@Composable
fun SootheBottomNavigation(modifier: Modifier = Modifier, select: Int, onBottomItemClicked: (Int) -> Unit) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = select == 0,
            onClick = {
                onBottomItemClicked(0)
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = select == 1,
            onClick = {
                onBottomItemClicked(1)
            }
        )
    }
}