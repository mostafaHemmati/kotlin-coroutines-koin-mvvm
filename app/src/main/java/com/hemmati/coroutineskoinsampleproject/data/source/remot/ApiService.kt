package com.hemmati.coroutineskoinsampleproject.data.source.remot

import com.hemmati.coroutineskoinsampleproject.domain.model.profile.ProfileModel
import com.hemmati.coroutineskoinsampleproject.domain.model.videos.Videos
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("mostviewedvideos")
    suspend fun getVideos(): Videos

    @GET("profile/username/{username}")
    suspend fun getProfile(@Path("username") userName: String): ProfileModel
}