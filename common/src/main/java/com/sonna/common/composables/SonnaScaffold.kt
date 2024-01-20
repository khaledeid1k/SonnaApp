package com.sonna.common.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SonnaScaffold(
    titleOfTopBar: String = "",
    navigationBack: () -> Unit = {},
    isAppBarExisting: Boolean = false,
    isTopBarVisibleDuringScroll: Boolean = false,
    content: @Composable (PaddingValues) -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val isScrolled = remember { derivedStateOf { scrollBehavior.state.contentOffset < -100f } }
    Scaffold(
        topBar = {
            AnimatedVisibility(visible = isAppBarExisting && (!isTopBarVisibleDuringScroll || isScrolled.value)) {
                SonnaAppBar(
                    scrollBehavior = scrollBehavior,
                    navigationBack = navigationBack,
                    titleOfTopBar = titleOfTopBar
                )
            }
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { values ->
        content(values)
    }


}
