package com.hemmati.coroutineskoinsampleproject.presentation.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.coroutineskoinsampleproject.domain.exeption.ApiError
import com.hemmati.coroutineskoinsampleproject.domain.model.profile.ProfileModel
import com.hemmati.coroutineskoinsampleproject.domain.usecase.GetProfileUseCase
import com.hemmati.coroutineskoinsampleproject.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel

class ProfileViewMode constructor(private val profileUseCase: GetProfileUseCase) : ViewModel() {
    val profileData = MutableLiveData<ProfileModel>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getProfile(userName: String) {
        showProgressbar.value = true
        profileUseCase.invoke(viewModelScope, userName, object : UseCaseResponse<ProfileModel> {
            override fun onSuccess(result: ProfileModel) {
                showProgressbar.value = false
                profileData.value = result
            }

            override fun onError(apiError: ApiError?) {
                showProgressbar.value = false
                messageData.value = apiError?.getErrorMessage()
            }

        })

    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}