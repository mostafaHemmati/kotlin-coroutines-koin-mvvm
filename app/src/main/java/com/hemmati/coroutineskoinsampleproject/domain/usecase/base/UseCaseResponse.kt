package com.hemmati.coroutineskoinsampleproject.domain.usecase.base

import com.hemmati.coroutineskoinsampleproject.domain.exeption.ApiError


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

