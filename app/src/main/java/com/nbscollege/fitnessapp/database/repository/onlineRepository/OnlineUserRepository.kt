package com.nbscollege.fitnessapp.database.repository.onlineRepository

import com.nbscollege.fitnessapp.authscreen.model.User
import com.nbscollege.fitnessapp.database.network.HttpRoutes
import com.nbscollege.fitnessapp.database.network.KtorClient
import com.nbscollege.fitnessapp.database.repository.UserRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OnlineUserRepository(private val ktorClient: HttpClient = KtorClient() ) : UserRepository {
    override fun getAllUsersStream(): Flow<List<User>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserStream(username: String, password: String): Flow<User?> {
        val cl = ktorClient.request(
            HttpRoutes.login
        ) {
            method = HttpMethod.Post
            url(HttpRoutes.login)
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            setBody(MultiPartFormDataContent(formData {
                append("type", "login")
                append("username", username)
                append("username", password)
            }))
        }
        return flow {
            emit(cl.body())
        }
    }

    override suspend fun insertUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun updateUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun changePassword(username: String, newPassword: String) {
        TODO("Not yet implemented")
    }

}