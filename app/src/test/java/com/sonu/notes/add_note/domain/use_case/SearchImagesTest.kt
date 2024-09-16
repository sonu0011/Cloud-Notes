package com.sonu.notes.add_note.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sonu.notes.add_note.presentation.util.Resource
import com.sonu.notes.core.data.repository.FakeImagesRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class SearchImagesTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var fakeImagesRepository: FakeImagesRepository
    private lateinit var searchImages: com.sonu.notes.add_note.domain.use_case.SearchImages

    @Before
    fun setUp() {
        fakeImagesRepository = FakeImagesRepository()
        searchImages =
            com.sonu.notes.add_note.domain.use_case.SearchImages(fakeImagesRepository)
    }

    @Test
    fun `search images with empty query, returns error`() = runTest {
        searchImages.invoke("")
            .collect { result ->
                when (result) {
                    is Resource.Error -> {
                        assertThat(
                            result.data?.images == null
                        ).isTrue()
                    }

                    is Resource.Loading -> Unit
                    is Resource.Success -> Unit
                }
            }
    }

    @Test
    fun `search images a valid query but with network error, returns error`() = runTest {
        fakeImagesRepository.setShouldReturnError(true)
        searchImages.invoke("")
            .collect { result ->
                when (result) {
                    is Resource.Error -> {
                        assertThat(
                            result.data?.images == null
                        ).isTrue()
                    }

                    is Resource.Loading -> Unit
                    is Resource.Success -> Unit
                }
            }
    }

    @Test
    fun `search images with a valid query, returns success`() = runTest {
        searchImages.invoke("query")
            .collect { result ->
                when (result) {
                    is Resource.Error -> Unit
                    is Resource.Loading -> Unit
                    is Resource.Success -> {
                        assertThat(
                            result.data?.images != null
                        ).isTrue()
                    }
                }
            }
    }

    @Test
    fun `search images with a valid query, list is not empty`() = runTest {
        searchImages.invoke("query")
            .collect { result ->
                when (result) {
                    is Resource.Error -> Unit
                    is Resource.Loading -> Unit
                    is Resource.Success -> {
                        assertThat(
                            result.data?.images?.size!! > 0
                        ).isTrue()
                    }
                }
            }
    }

}




















