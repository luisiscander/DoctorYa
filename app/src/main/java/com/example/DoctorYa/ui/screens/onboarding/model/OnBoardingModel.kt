package com.example.DoctorYa.ui.screens.onboarding.model

import androidx.annotation.DrawableRes
import com.example.DoctorYa.R


data class OnBoardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)



fun getOnBoardingData(): List<OnBoardingModel> {
    return listOf(
        OnBoardingModel(image = R.drawable.image1, title = " Care of You", description = " is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been "),
        OnBoardingModel(image = R.drawable.image2, title = " Most Value", description = " text ever since the 1500s, when an unknown printer took a galley of type and scrambled  "),
        OnBoardingModel(image = R.drawable.image3, title = " Results", description = " It has survived not only five centuries, but also the leap into electronic typesetting ")
    )

}