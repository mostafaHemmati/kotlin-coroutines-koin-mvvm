package com.hemmati.coroutineskoinsampleproject.domain.usecase

import com.hemmati.coroutineskoinsampleproject.domain.model.profile.ProfileModel
import com.hemmati.coroutineskoinsampleproject.domain.repository.ProfileRepository
import com.hemmati.coroutineskoinsampleproject.domain.usecase.base.UseCase

class GetProfileUseCase constructor(private val profileRepository: ProfileRepository) :
    UseCase<ProfileModel, Any?>() {
    override suspend fun run(params: Any?): ProfileModel {
        return profileRepository.getProfile(params.toString())
    }
}