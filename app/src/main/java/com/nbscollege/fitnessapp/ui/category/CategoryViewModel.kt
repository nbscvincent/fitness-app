package com.nbscollege.fitnessapp.ui.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.repository.CategoryRepository
import com.nbscollege.fitnessapp.mainscreen.dataclass.Category

class CategoryViewModel(private val categoryRepository: CategoryRepository) : ViewModel() {

    /**
     * Holds current user ui state
     */
    var categoryUiState by mutableStateOf(UserUiState())
        private set
}
/**
 * Represents Ui State for an User.
 */
data class CategoryUiState(
    var categoryDetails: CategoryDetails = CategoryDetails(),
    val isEntryValid: Boolean = false
)
data class CategoryDetails(
    val title: String = "",
    val exerciseCount: String = "",
    val subTitle: String = "",
    val backgroundImageResourceId: Int = 0,
    val gif: Int = 0,
    val route: String = "",
)
/**
 * Extension function to convert [UserUiState] to [User]. If the value of [UserDetails.price] is
 * not a valid [Double], then the price will be set to 0.0. Similarly if the value of
 * [UserUiState] is not a valid [Int], then the quantity will be set to 0
 */
fun CategoryDetails.toCategory(): Category = Category (
    title = title,
    exerciseCount = exerciseCount,
    subTitle = subTitle,
    backgroundImageResourceId = backgroundImageResourceId,
    gif = gif,
    route = route,
)
/**
 * Extension function to convert [Item] to [ItemUiState]
 */
fun Category.toCategoryUiState(isEntryValid: Boolean = false): CategoryUiState = CategoryUiState(
    categoryDetails = this.toCategoryDetails(),
    isEntryValid = isEntryValid
)
/**
 * Extension function to convert [Item] to [ItemDetails]
 */
fun Category.toCategoryDetails(): CategoryDetails = CategoryDetails(
    title = title,
    exerciseCount = exerciseCount,
    subTitle = subTitle,
    backgroundImageResourceId = backgroundImageResourceId,
    gif = gif,
    route = route,
)