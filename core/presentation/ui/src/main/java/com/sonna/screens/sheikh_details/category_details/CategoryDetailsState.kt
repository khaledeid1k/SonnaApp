package com.sonna.screens.sheikh_details.category_details

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import com.sonna.common.R
import com.sonna.common.composables.BottomSheetItemState
import com.sonna.screens.sheikh_details.Voice

data class CategoryDetailsState(
    val categoryPic:Int= R.drawable.shek_gamal,
    val titleOfCategory:String= "علاج قسوه القلب ",
    val numberOfTracks:Int= 20,
    val timeOfPublished:Int= 15,
    val nameOfSheikh: String= "Gamal Ali",
    val voicesOfCategory: List<Voice> = listOf(
        Voice(
            numberOfVoice = 1,
            nameOfVoice = "الجنه ونعيمها",
            time = "40.10",
            picture = R.drawable.shek_gamal,
        ),
        Voice(
            numberOfVoice = 2,
            nameOfVoice = "اعمال شهر رجب",
            time = "50.20",
            picture = R.drawable.shek_gamal,
        ),
        Voice(
            numberOfVoice = 3,
            nameOfVoice = "ما بعد رمضان",
            time = "55.40",
            picture = R.drawable.shek_gamal,
        ),
        Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 4,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),  Voice(
            numberOfVoice = 9,
            nameOfVoice = "كيف ننصر فلسطين ؟",
            time = "30.25",
            picture = R.drawable.shek_gamal,
        ),

        ),
    val itemsOfBottomSheet: List<BottomSheetItemState> = listOf(
        BottomSheetItemState(
            title = R.string.add_to_favorites,
            imageVector = Icons.Default.FavoriteBorder) {},
        BottomSheetItemState(title = R.string.share) {},
        BottomSheetItemState(title = R.string.report, haveImageVector = false) {}
    )


)
