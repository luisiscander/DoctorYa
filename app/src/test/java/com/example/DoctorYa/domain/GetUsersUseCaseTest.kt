package com.example.DoctorYa.domain

import app.cash.turbine.test
import com.example.DoctorYa.data.Repository

import com.example.DoctorYa.domain.model.user
import com.example.DoctorYa.utils.Result
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert

import org.junit.Test
@OptIn(ExperimentalCoroutinesApi::class)

class GetUsersUseCaseTest {

    private val repository = mockk<Repository>()

    private val getUsersUseCase = GetUsersUseCase(repository)


    @Test
    fun `when repository return succes`()= runTest {

        //given
        val users = listOf( user(1, name = "Luis", username = "luis", email = "luis@12"), user(id = 2, name = "ana", username = "ana", email = "ana@123"))
        val expected = Result.Success(data = users)
        every { repository.getUsersFromApi() } returns flowOf(expected)

        //when
        val useCase = getUsersUseCase()

        //then
        useCase.test {
            val emission: Result<List<user>> = awaitItem()
            assertThat(emission).isInstanceOf(Result.Success::class.java)

            awaitComplete()


        }


    }


    @Test
    fun `when repository return Error`() = runTest {

        //given
        val expected= Result.Error<List<user>>(message = " Error")
        every { repository.getUsersFromApi() } returns flowOf(expected)
        //when
        val response= getUsersUseCase()

        //then
        response.test {
            val emission = awaitItem()
             assertThat(emission).isInstanceOf(Result.Error::class.java)
            awaitComplete()


        }


    }
}