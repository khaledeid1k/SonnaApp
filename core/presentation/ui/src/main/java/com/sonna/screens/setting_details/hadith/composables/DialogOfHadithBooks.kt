package com.sonna.screens.setting_details.hadith.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.sonna.common.R
import com.sonna.common.previews.ThemePreviews
import com.sonna.common.theme.SonnaAppTheme
import com.sonna.common.theme.dimension
import com.sonna.viewmodel.setting_details.hadith.HadithDialogSettingState
import com.sonna.viewmodel.setting_details.hadith.HadithSettingState

@Composable
fun DialogOfHadithBooks(
    hadithSettingState: HadithSettingState,
    onDismissRequest: () -> Unit = {},
    isHadithBookDownloaded: Boolean = false,
    changeSelectedHadithDB: (String) -> Unit = {},
    downloadHadithBook: (String) -> Unit = {},
    hadithDialogSettingState: HadithDialogSettingState = hadithSettingState.hadithDialogSettingState
) {
    var selectedOption by remember { mutableStateOf(hadithDialogSettingState.selectedHadithBookName) }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(MaterialTheme.dimension.padding16)
        ) {
            Text(
                modifier = Modifier,
                text = stringResource(id = R.string.hadith_book),
                style = MaterialTheme.typography.titleMedium
            )
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
            ) {
                items(hadithDialogSettingState.hadithBooks) {
                    HadithBookName(

                        hadithBook = it.hadithBookText,

                        download = it.download,

                        changeSelectedHadith = { newValue ->
//                            if (isHadithBookDownloaded) {
//                                changeSelectedHadithDB(newValue)
                                selectedOption = newValue
//                            } else {
                            // downloadHadithBook(newValue)
                            //    }
                        },

                        selectedOption = selectedOption,

                        downloadHadithBook = { newValue -> downloadHadithBook(newValue) }
                    )
                }
            }
        }


    }
}

@Composable
private fun HadithBookName(
    hadithBook: String,
    download: Boolean,
    selectedOption: String,
    changeSelectedHadith: (String) -> Unit,
    downloadHadithBook: (String) -> Unit
) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
    ) {
        RadioButton(selected = hadithBook == selectedOption,

            onClick = { changeSelectedHadith(hadithBook) })
        Text(
            modifier = Modifier.weight(1f),
            text = hadithBook,
            style = MaterialTheme.typography.titleSmall
        )
        if (!download) {
            Icon(
                modifier = Modifier.clickable { downloadHadithBook(hadithBook) },
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
        DialogOfHadithBooks(HadithSettingState())
    }
}