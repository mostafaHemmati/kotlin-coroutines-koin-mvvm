package com.hemmati.coroutineskoinsampleproject.domain.usecase

import com.hemmati.coroutineskoinsampleproject.domain.usecase.base.UseCase
import com.hemmati.coroutineskoinsampleproject.domain.model.videos.Videos
import com.hemmati.coroutineskoinsampleproject.domain.repository.VideosRepository

class GetVideosUseCase constructor(private val videosRepository: VideosRepository) :
    UseCase<Videos, Any?>() {
    override suspend fun run(params: Any?): Videos {
        return videosRepository.getVideos()
    }
}