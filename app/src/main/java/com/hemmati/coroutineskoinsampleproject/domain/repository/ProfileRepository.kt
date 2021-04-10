package com.hemmati.coroutineskoinsampleproject.domain.repository

import com.hemmati.coroutineskoinsampleproject.domain.model.profile.ProfileModel

interface ProfileRepository {
    suspend fun getProfile(userName:String): ProfileModel
}