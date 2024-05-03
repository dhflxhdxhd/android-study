package com.example.domain.usecase.login

interface SignUpUseCase {
    suspend operator fun invoke(
        username : String, id:String, password : String
    ):Result<Unit>
}