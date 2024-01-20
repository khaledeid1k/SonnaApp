package com.sonna.common.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sonna.common.theme.dimension

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SonnaBottomSheet(
    changeBottomSheetVisibility: Boolean,
    onDismissRequest: () -> Unit,
    bottomSheetItems: List<BottomSheetItemState>
) {
    val stateBottomSheet = rememberModalBottomSheetState()

    if (changeBottomSheetVisibility) {
        ModalBottomSheet(
            sheetState = stateBottomSheet,
            onDismissRequest = {
                onDismissRequest()

            }) {
            LazyColumn(modifier = Modifier.padding(MaterialTheme.dimension.padding16)){
                items(bottomSheetItems){item->
                    SonnaBottomSheetItem(item)
                }
            }


        }
    }
}

