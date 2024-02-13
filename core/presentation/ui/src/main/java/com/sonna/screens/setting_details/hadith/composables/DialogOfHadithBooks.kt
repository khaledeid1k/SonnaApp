package com.sonna.screens.setting_details.hadith.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.sonna.common.R
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.screens.setting_details.hadith.HadithSettingState

@Composable
fun DialogOfHadithBooks(
    onDismissRequest: () -> Unit = {},
    startDownload: () -> Unit = {},
    hadithSettingState: HadithSettingState = HadithSettingState()
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Column(modifier = Modifier.padding(MaterialTheme.dimension.padding16)) {
            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.hadith_book),
                style = MaterialTheme.typography.titleMedium
            )
            LazyColumn(

                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
            ) {
                items(hadithSettingState.hadithBooks) {
                    HadithBookName(it.hadithBook, it.download) { startDownload() }
                }
            }
        }


    }
}

@Composable
private fun HadithBookName(hadithBook: String, download: Boolean, startDownload: () -> Unit) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = hadithBook,
            style = MaterialTheme.typography.titleSmall
        )
        if (!download) {
            Icon(
                modifier = Modifier.clickable { startDownload() },
                painter = painterResource(id = R.drawable.download_book),
                contentDescription = ""
            )


        }
    }
}

@ThemePreviews
@Composable
fun DialogOfHadithBooksPreview() {
    SonnaAppTheme {
        DialogOfHadithBooks()
    }
}