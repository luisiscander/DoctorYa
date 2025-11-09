package com.example.DoctorYa.ui.screens.onboarding

import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.DoctorYa.ui.screens.onboarding.model.getOnBoardingData
import com.example.DoctorYa.ui.theme.primary


@Composable
fun OnBoardingScreen(navigateTo: () -> Unit) {
    val dataList = getOnBoardingData()

    Column(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState { dataList.size }
        //Horizpontal pager
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            verticalAlignment = Alignment.CenterVertically,
            state = pagerState
        ) { page ->
            val data= dataList[page]
             Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                 Image(painter = painterResource(data.image), contentDescription = "image",
                     modifier = Modifier.fillMaxSize(0.5f))

                 Spacer(modifier = Modifier.height(24.dp))

                 Text(text = data.title, style = TextStyle(fontSize = 24.sp,
                     fontWeight = FontWeight.Bold,
                     textAlign = TextAlign.Center,
                     color = primary))

                 Spacer(modifier = Modifier.height(16.dp))

                 Text(text = data.description, style = TextStyle(fontSize = 12.sp,
                     fontWeight = FontWeight.Medium,
                     textAlign = TextAlign.Center,
                     color = Color.Black))

             }


        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(2f),
            horizontalArrangement = Arrangement.Center
           ) {

            repeat(dataList.size){
                Box(modifier = Modifier.
                    padding(4.dp)
                    .size(10.dp)
                    .background(
                        color = if (pagerState.currentPage == it) primary else Color.Black,
                        shape = CircleShape
                    )
                    )

            }
        }


        Row(modifier = Modifier
            .fillMaxWidth().padding(bottom = 16.dp)
            .weight(1f))

        {
            AnimatedVisibility(pagerState.currentPage == dataList.size-1) {

                OutlinedButton(onClick = {navigateTo()}, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)) {

                    Text("Start")
                }


            }

        }



    }


}
