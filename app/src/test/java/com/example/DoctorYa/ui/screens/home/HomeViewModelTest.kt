package com.example.DoctorYa.ui.screens.home

import app.cash.turbine.test
import com.example.DoctorYa.domain.GetUsersUseCase
import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.MainDispatcherRule
import com.example.DoctorYa.utils.Result
import com.example.DoctorYa.utils.UiState
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.emptyFlow

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test


class HomeViewModelTest {

    private val getUserUseCase = mockk<GetUsersUseCase>()

    @get:Rule
    val mainDispatcherRule= MainDispatcherRule()

    @Test
    fun` useCase returns Error THEN state transitions to Loading then Error`()= runTest {
        //given
        val error= Result.Error<List<user>>(message = " Network Error")
        every { getUserUseCase() } returns flowOf(error)

        //when
        val viewModel= HomeViewModel(getUserUseCase)

        //then
        viewModel.state.test {

            // val emission = awaitItem()
             //assertThat(emission).isInstanceOf(UiState.Loading::class.java)

            val errorState= awaitItem()
            assertThat(errorState).isInstanceOf(UiState.Error::class.java)
            assertThat((errorState as UiState.Error).message).isEqualTo(error.message)

             cancelAndIgnoreRemainingEvents()

         }


    }



    @Test
    fun` when ViewModel is inizialited then the state is loading`() = runTest {

        //given
        every { getUserUseCase() } returns emptyFlow()
        //when
        val viemodel = HomeViewModel(getUserUseCase)
        //then
        val initialState= viemodel.state.value
          assertThat(initialState).isInstanceOf(UiState.Loading::class.java)





    }



}