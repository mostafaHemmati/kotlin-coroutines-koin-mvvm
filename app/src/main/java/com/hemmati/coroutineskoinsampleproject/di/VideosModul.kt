package com.hemmati.coroutineskoinsampleproject.di

import com.hemmati.coroutineskoinsampleproject.data.repository.VideosRepositoryImp
import com.hemmati.coroutineskoinsampleproject.data.source.remot.ApiService
import com.hemmati.coroutineskoinsampleproject.domain.repository.VideosRepository
import com.hemmati.coroutineskoinsampleproject.domain.usecase.GetVideosUseCase
import com.hemmati.coroutineskoinsampleproject.presentation.videos.VideosViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VideosModule = module {
    viewModel { VideosViewModel(get()) }
    single { createGetVideosUseCase(get()) }
    single { createVideosRepository(get()) }
}


fun createVideosRepository(apiService: ApiService): VideosRepository {
    return VideosRepositoryImp(apiService)
}

fun createGetVideosUseCase(videosRepository: VideosRepository): GetVideosUseCase {
    return GetVideosUseCase(videosRepository)
}