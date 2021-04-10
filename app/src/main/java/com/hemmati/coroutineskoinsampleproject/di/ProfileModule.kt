package com.hemmati.coroutineskoinsampleproject.di

import com.hemmati.coroutineskoinsampleproject.data.repository.ProfileRepositoryImp
import com.hemmati.coroutineskoinsampleproject.data.source.remot.ApiService
import com.hemmati.coroutineskoinsampleproject.domain.repository.ProfileRepository
import com.hemmati.coroutineskoinsampleproject.domain.usecase.GetProfileUseCase
import com.hemmati.coroutineskoinsampleproject.presentation.profile.ProfileViewMode
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel { ProfileViewMode(get()) }
    single { createGetProfileUseCase(get()) }
    single { createProfileRepository(get()) }
}

fun createProfileRepository(apiService: ApiService): ProfileRepository {
    return ProfileRepositoryImp(apiService)
}

fun createGetProfileUseCase(profileRepository: ProfileRepository): GetProfileUseCase {
    return GetProfileUseCase(profileRepository)
}