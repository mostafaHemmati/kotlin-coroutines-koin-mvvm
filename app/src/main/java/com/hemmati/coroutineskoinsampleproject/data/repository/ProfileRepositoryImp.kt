package com.hemmati.coroutineskoinsampleproject.data.repository

import com.hemmati.coroutineskoinsampleproject.data.source.remot.ApiService
import com.hemmati.coroutineskoinsampleproject.domain.model.profile.ProfileModel
import com.hemmati.coroutineskoinsampleproject.domain.repository.ProfileRepository

class ProfileRepositoryImp(private val apiService: ApiService) : ProfileRepository {

    override suspend fun getProfile(userName: String): ProfileModel {
       return apiService.getProfile(userName)
    }
}