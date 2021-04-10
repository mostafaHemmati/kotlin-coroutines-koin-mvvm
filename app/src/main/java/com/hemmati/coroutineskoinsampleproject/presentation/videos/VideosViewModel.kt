package com.hemmati.coroutineskoinsampleproject.presentation.videos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.coroutineskoinsampleproject.domain.exeption.ApiError
import com.hemmati.coroutineskoinsampleproject.domain.model.videos.Videos
import com.hemmati.coroutineskoinsampleproject.domain.usecase.GetVideosUseCase
import com.hemmati.coroutineskoinsampleproject.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel

class VideosViewModel constructor(private val getVideosUseCase: GetVideosUseCase) : ViewModel() {
    val videosData = MutableLiveData<Videos>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getVideos() {
        showProgressbar.value = true

        getVideosUseCase.invoke(viewModelScope, null, object : UseCaseResponse<Videos> {
            override fun onSuccess(result: Videos) {
                Log.d(TAG, "onSuccess: $result")
                videosData.value = result
                showProgressbar.value = false
            }

            override fun onError(apiError: ApiError?) {
                messageData.value = apiError?.getErrorMessage()
                showProgressbar.value = false
            }

        })
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
    companion object{
        private const val TAG = "VideosViewModel"
    }

}