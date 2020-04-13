package hu.tajti.themealapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class RandomMealDto(
    @SerializedName("idMeal")
    var idMeal: String? = null,
    @SerializedName("strMeal")
    var strMeal: String? = null,
    @SerializedName("strDrinkAlternate")
    var strDrinkAlternate: String? = null,
    @SerializedName("strCategory")
    var strCategory: String? = null,
    @SerializedName("strArea")
    var strArea: String? = null,
    @SerializedName("strInstructions")
    var strInstructions: String? = null,
    @SerializedName("strMealThumb")
    var strMealThumb: String? = null,
    @SerializedName("strTags")
    var strTags: String? = null,
    @SerializedName("strYoutube")
    var strYoutube: String? = null,
    @SerializedName("strIngredient1")
    var strIngredient1: String? = null,
    @SerializedName("strIngredient2")
    var strIngredient2: String? = null,
    @SerializedName("strIngredient3")
    var strIngredient3: String? = null,
    @SerializedName("strIngredient4")
    var strIngredient4: String? = null,
    @SerializedName("strIngredient5")
    var strIngredient5: String? = null,
    @SerializedName("strIngredient6")
    var strIngredient6: String? = null,
    @SerializedName("strIngredient7")
    var strIngredient7: String? = null,
    @SerializedName("strIngredient8")
    var strIngredient8: String? = null,
    @SerializedName("strIngredient9")
    var strIngredient9: String? = null,
    @SerializedName("strIngredient10")
    var strIngredient10: String? = null,
    @SerializedName("strIngredient11")
    var strIngredient11: String? = null,
    @SerializedName("strIngredient12")
    var strIngredient12: String? = null,
    @SerializedName("strIngredient13")
    var strIngredient13: String? = null,
    @SerializedName("strIngredient14")
    var strIngredient14: String? = null,
    @SerializedName("strIngredient15")
    var strIngredient15: String? = null,
    @SerializedName("strIngredient16")
    var strIngredient16: String? = null,
    @SerializedName("strIngredient17")
    var strIngredient17: String? = null,
    @SerializedName("strIngredient18")
    var strIngredient18: String? = null,
    @SerializedName("strIngredient19")
    var strIngredient19: String? = null,
    @SerializedName("strIngredient20")
    var strIngredient20: String? = null,
    @SerializedName("strMeasure1")
    var strMeasure1: String? = null,
    @SerializedName("strMeasure2")
    var strMeasure2: String? = null,
    @SerializedName("strMeasure3")
    var strMeasure3: String? = null,
    @SerializedName("strMeasure4")
    var strMeasure4: String? = null,
    @SerializedName("strMeasure5")
    var strMeasure5: String? = null,
    @SerializedName("strMeasure6")
    var strMeasure6: String? = null,
    @SerializedName("strMeasure7")
    var strMeasure7: String? = null,
    @SerializedName("strMeasure8")
    var strMeasure8: String? = null,
    @SerializedName("strMeasure9")
    var strMeasure9: String? = null,
    @SerializedName("strMeasure10")
    var strMeasure10: String? = null,
    @SerializedName("strMeasure11")
    var strMeasure11: String? = null,
    @SerializedName("strMeasure12")
    var strMeasure12: String? = null,
    @SerializedName("strMeasure13")
    var strMeasure13: String? = null,
    @SerializedName("strMeasure14")
    var strMeasure14: String? = null,
    @SerializedName("strMeasure15")
    var strMeasure15: String? = null,
    @SerializedName("strMeasure16")
    var strMeasure16: String? = null,
    @SerializedName("strMeasure17")
    var strMeasure17: String? = null,
    @SerializedName("strMeasure18")
    var strMeasure18: String? = null,
    @SerializedName("strMeasure19")
    var strMeasure19: String? = null,
    @SerializedName("strMeasure20")
    var strMeasure20: String? = null,
    @SerializedName("strSource")
    var strSource: String? = null,
    @SerializedName("dateModifier")
    var dateModified: Date? = null
) {
    fun getIngredientsString(): String = listOf(
        "${strMeasure1 ?: ""}|${strIngredient1 ?: ""}".trim(),
        "${strMeasure2 ?: ""}|${strIngredient2 ?: ""}".trim(),
        "${strMeasure3 ?: ""}|${strIngredient3 ?: ""}".trim(),
        "${strMeasure4 ?: ""}|${strIngredient4 ?: ""}".trim(),
        "${strMeasure5 ?: ""}|${strIngredient5 ?: ""}".trim(),
        "${strMeasure6 ?: ""}|${strIngredient6 ?: ""}".trim(),
        "${strMeasure7 ?: ""}|${strIngredient7 ?: ""}".trim(),
        "${strMeasure8 ?: ""}|${strIngredient8 ?: ""}".trim(),
        "${strMeasure9 ?: ""}|${strIngredient9 ?: ""}".trim(),
        "${strMeasure10 ?: ""}|${strIngredient10 ?: ""}".trim(),
        "${strMeasure11 ?: ""}|${strIngredient11 ?: ""}".trim(),
        "${strMeasure12 ?: ""}|${strIngredient12 ?: ""}".trim(),
        "${strMeasure13 ?: ""}|${strIngredient13 ?: ""}".trim(),
        "${strMeasure14 ?: ""}|${strIngredient14 ?: ""}".trim(),
        "${strMeasure15 ?: ""}|${strIngredient15 ?: ""}".trim(),
        "${strMeasure16 ?: ""}|${strIngredient16 ?: ""}".trim(),
        "${strMeasure17 ?: ""}|${strIngredient17 ?: ""}".trim(),
        "${strMeasure18 ?: ""}|${strIngredient18 ?: ""}".trim(),
        "${strMeasure19 ?: ""}|${strIngredient19 ?: ""}".trim(),
        "${strMeasure20 ?: ""}|${strIngredient20 ?: ""}".trim()
    ).filter { it.length != 1 }.joinToString(",")

    fun hasValidMeasures(): Boolean {
        return !(strMeasure1?.contains(Regex("[-/]")) ?: false) && !(strMeasure1?.lastOrNull()?.isDigit() ?: false) && strMeasure1?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure2?.contains(Regex("[-/]")) ?: false) && !(strMeasure2?.lastOrNull()?.isDigit() ?: false) && strMeasure2?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure3?.contains(Regex("[-/]")) ?: false) && !(strMeasure3?.lastOrNull()?.isDigit() ?: false) && strMeasure3?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure4?.contains(Regex("[-/]")) ?: false) && !(strMeasure4?.lastOrNull()?.isDigit() ?: false) && strMeasure4?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure5?.contains(Regex("[-/]")) ?: false) && !(strMeasure5?.lastOrNull()?.isDigit() ?: false) && strMeasure5?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure6?.contains(Regex("[-/]")) ?: false) && !(strMeasure6?.lastOrNull()?.isDigit() ?: false) && strMeasure6?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure7?.contains(Regex("[-/]")) ?: false) && !(strMeasure7?.lastOrNull()?.isDigit() ?: false) && strMeasure7?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure8?.contains(Regex("[-/]")) ?: false) && !(strMeasure8?.lastOrNull()?.isDigit() ?: false) && strMeasure8?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure9?.contains(Regex("[-/]")) ?: false) && !(strMeasure9?.lastOrNull()?.isDigit() ?: false) && strMeasure9?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure10?.contains(Regex("[-/]")) ?: false) && !(strMeasure10?.lastOrNull()?.isDigit() ?: false) && strMeasure10?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure11?.contains(Regex("[-/]")) ?: false) && !(strMeasure11?.lastOrNull()?.isDigit() ?: false) && strMeasure11?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure12?.contains(Regex("[-/]")) ?: false) && !(strMeasure12?.lastOrNull()?.isDigit() ?: false) && strMeasure12?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure13?.contains(Regex("[-/]")) ?: false) && !(strMeasure13?.lastOrNull()?.isDigit() ?: false) && strMeasure13?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure14?.contains(Regex("[-/]")) ?: false) && !(strMeasure14?.lastOrNull()?.isDigit() ?: false) && strMeasure14?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure15?.contains(Regex("[-/]")) ?: false) && !(strMeasure15?.lastOrNull()?.isDigit() ?: false) && strMeasure15?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure16?.contains(Regex("[-/]")) ?: false) && !(strMeasure16?.lastOrNull()?.isDigit() ?: false) && strMeasure16?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure17?.contains(Regex("[-/]")) ?: false) && !(strMeasure17?.lastOrNull()?.isDigit() ?: false) && strMeasure17?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure18?.contains(Regex("[-/]")) ?: false) && !(strMeasure18?.lastOrNull()?.isDigit() ?: false) && strMeasure18?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure19?.contains(Regex("[-/]")) ?: false) && !(strMeasure19?.lastOrNull()?.isDigit() ?: false) && strMeasure19?.getOrNull(0)?.isDigit() ?: true &&
                !(strMeasure20?.contains(Regex("[-/]")) ?: false) && !(strMeasure20?.lastOrNull()?.isDigit() ?: false) && strMeasure20?.getOrNull(0)?.isDigit() ?: true
    }
}