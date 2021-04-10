package com.hemmati.coroutineskoinsampleproject.domain.repository

import com.hemmati.coroutineskoinsampleproject.domain.model.videos.Videos

interface VideosRepository {
    suspend fun getVideos(): Videos
}