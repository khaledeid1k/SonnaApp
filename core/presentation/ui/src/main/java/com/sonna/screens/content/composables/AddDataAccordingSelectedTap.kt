package com.sonna.screens.content.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.sonna.common.theme.dimension
import com.sonna.viewmodel.content.ContentState

@Composable
fun AddDataAccordingSelectedTap(state: ContentState){
    LazyColumn(
        contentPadding = PaddingValues(vertical = MaterialTheme.dimension.padding16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimension.padding8)
    ) {
        when (state.selectedTabIndex){
            Taps.QURAN.index ->{
                items(state.surahesList) { surah ->
                    ContentListCard(
                        numberOfContent = surah.number,
                        name = surah.name,
                        englishName = surah.englishName,
                        hintOfContent = surah.numberOfAyahs.toString()
                    )
                }
            }
            Taps.HADITH.index -> {
                val numbersOfAhadith = (1..state.hadithBookInfo.second).map {
                    NumberTranslation(
                      "Al Hadith " +convertNumberToEnglishString(it),
                  "الحديث " +convertNumberToArabicString(it)
                    )
                }
                items(count = numbersOfAhadith.size){ hadith->
                    ContentListCard(
                        numberOfContent = hadith + 1,
                        name = numbersOfAhadith[hadith].arabic,
                        englishName = numbersOfAhadith[hadith].english,
                        hintOfContent = state.hadithBookInfo.first
                    )
                }
            }
            Taps.AZKAR.index -> {
                items(count = state.azkarList.size) {
                    ContentListCard(
                        numberOfContent = it + 1,
                        name = state.azkarList[it].name,
                        hintOfContent = state.azkarList[it].numberOfAzkar.toString()
                    )
                }
            }
        }







    }

}

enum class Taps(val index: Int) {
    QURAN(0),HADITH(1),AZKAR(2)
}

data class NumberTranslation(val english: String, val arabic: String)
fun convertNumberToArabicString(num: Int): String {
    val onesArabic =
        arrayOf("", "واحد", "اثنان", "ثلاثة", "أربعة", "خمسة", "ستة", "سبعة", "ثمانية", "تسعة","عشرة")
    val tensArabic = arrayOf(
        "",
        "",
        "عشرون",
        "ثلاثون",
        "أربعون",
        "خمسون",
        "ستون",
        "سبعون",
        "ثمانون",
        "تسعون"
    )

    if(num==1){return "الأول"}
    if(num==2){return "الثاني"}
    if(num==3){return "الثالث"}
    if(num==4){return "الرابع"}
    if(num==5){return "الخامس"}
    if(num==6){return "السادس"}
    if(num==7){return "السابع"}
    if(num==8){return "الثامن"}
    if(num==9){return "التاسع"}
    if(num==10){return "العاشر"}
    if (num == 11) return "الحادي عشر"
    if (num == 12) return "الثاني عشر"
    if (num == 13) return "الثالث عشر"
    if (num == 14) return "الرابع عشر"
    if (num == 15) return "الخامس عشر"
    if (num == 16) return "السادس عشر"
    if (num == 17) return "السابع عشر"
    if (num == 18) return "الثامن عشر"
    if (num == 19) return "التاسع عشر"
    if (num < 10) return onesArabic[num]
    if (num < 100) return if (num % 10 != 0) {
        onesArabic[num % 10] + " و"
    } else {
        ""
    } + tensArabic[num / 10]
    if (num < 1000) return onesArabic[num / 100] + " مئة" + if (num % 100 != 0) " و" + convertNumberToArabicString(
        num % 100
    ) else ""
    if (num < 10000) return onesArabic[num / 1000] + " آلاف" + if (num % 1000 != 0) " و" + convertNumberToArabicString(
        num % 1000
    ) else ""
    if (num < 1000000) return convertNumberToArabicString(num / 1000) + " آلاف" + if (num % 1000 != 0) " " + convertNumberToArabicString(
        num % 1000
    ) else ""

    return ""
}
fun convertNumberToEnglishString(num: Int): String {
    val ones = arrayOf("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    val tens = arrayOf("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    if (num < 10) return ones[num]
    if (num < 100) return tens[num / 10] + if (num % 10 != 0) " " + ones[num % 10] else ""
    if (num < 1000) return ones[num / 100] + " Hundred" + if (num % 100 != 0) " " + convertNumberToEnglishString(num % 100) else ""
    if (num < 10000) return ones[num / 1000] + " Thousand" + if (num % 1000 != 0) " " + convertNumberToEnglishString(num % 1000) else ""
    if (num < 1000000) return convertNumberToEnglishString(num / 1000) + " Thousand" + if (num % 1000 != 0) " " + convertNumberToEnglishString(num % 1000) else ""
    return ""
}