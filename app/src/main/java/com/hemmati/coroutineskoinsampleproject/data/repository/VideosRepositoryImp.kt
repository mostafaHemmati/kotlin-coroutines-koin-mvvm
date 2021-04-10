package com.hemmati.coroutineskoinsampleproject.data.repository

import com.hemmati.coroutineskoinsampleproject.data.source.remot.ApiService
import com.hemmati.coroutineskoinsampleproject.domain.model.videos.Videos
import com.hemmati.coroutineskoinsampleproject.domain.repository.VideosRepository

class VideosRepositoryImp(private val apiService: ApiService) : VideosRepository {

    override suspend fun getVideos(): Videos {
        return apiService.getVideos()
    }

}