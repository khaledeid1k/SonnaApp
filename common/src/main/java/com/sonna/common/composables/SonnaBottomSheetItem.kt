package com.sonna.common.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sonna.common.R
import com.sonna.common.theme.dimension

@Composable
fun SonnaBottomSheetItem(
    bottomSheetItemState: BottomSheetItemState,
) {
    Row(
        modifier = Modifier.padding(MaterialTheme.dimension.padding16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (bottomSheetItemState.haveImageVector) {
            IconButton( modifier = Modifier.size(MaterialTheme.dimension.size50),onClick = { bottomSheetItemState.clickItem() }) {
                Icon(
                    modifier = Modifier.padding(horizontal = MaterialTheme.dimension.padding16),
                    imageVector = bottomSheetItemState.imageVector,
                    contentDescription = ""
                )
            }

        } else {
            IconButton(  modifier = Modifier.size(MaterialTheme.dimension.size50),onClick = {
                bottomSheetItemState.clickItem()
            }) {
                Icon(
                    modifier = Modifier.padding(horizontal = MaterialTheme.dimension.padding16),
                    painter = painterResource(id = bottomSheetItemState.paintDrawable),
                    contentDescription = ""
                )
            }

        }
        Text(text = stringResource(id = bottomSheetItemState.title), modifier = Modifier.clickable {
            bottomSheetItemState.clickItem()
        })
    }

}
data class BottomSheetItemState(
    @StringRes val title: Int,
    val imageVector: ImageVector = Icons.Default.Share,
    val haveImageVector: Boolean = true,
    val paintDrawable: Int = R.drawable.report,
    val clickItem: () -> Unit
)
