package com.sonna.screens.sheikh_details

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import com.sonna.common.R
import com.sonna.common.composables.BottomSheetItemState

data class SheikhDetailsState(
    val nameOfSheikh: String ="Gamal Ali",
    val sheikhPic: Int =R.drawable.shek_gamal,
    val hintAboutSheikh: String =".Azhar",
    val popularVoices: List<Voice> = listOf(
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
        ),

    ),
    val categories: List<Category> = listOf(
        Category(
            numberOfVoice = 1,
            nameOfVoice = "رمضان",
            dateOfVoice = 2023,
            picture = R.drawable.shek_gamal,
        ),
        Category(
            numberOfVoice = 2,
            nameOfVoice = "الزكاه",
            dateOfVoice = 2022,
            picture = R.drawable.shek_gamal,
        ),
        Category(
            numberOfVoice = 3,
            nameOfVoice = "الصيام",
            dateOfVoice = 2024,
            picture = R.drawable.shek_gamal,
        ),
        Category(
            numberOfVoice = 4,
            nameOfVoice = "التفسر",
            dateOfVoice = 2021,
            picture = R.drawable.shek_gamal,
        ),
    ),
    val about:About=About(
        description ="Researcher in Hadith and its sciences, holds a Master’s degree in Hadith and its sciences, Al-Azhar University." ,
        picture = R.drawable.shek_gamal
    ),
   val itemsOfBottomSheet: List<BottomSheetItemState> = listOf(
       BottomSheetItemState(
           title = R.string.add_to_favorites,
           imageVector = Icons.Default.FavoriteBorder) {},
       BottomSheetItemState(title = R.string.share) {},
       BottomSheetItemState(title = R.string.report, haveImageVector = false) {}
       )

   )





data class Voice(
    val numberOfVoice: Int,
    val nameOfVoice: String ,
    val time: String ,
    val picture: Int ,
)

data class Category(
    val numberOfVoice: Int,
    val nameOfVoice: String ,
    val dateOfVoice: Int ,
    val picture: Int ,
)
data class About(
    val description:String,
    val picture: Int,
)

