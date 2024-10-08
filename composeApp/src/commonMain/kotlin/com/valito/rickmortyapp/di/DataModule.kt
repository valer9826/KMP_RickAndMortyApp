package com.valito.rickmortyapp.di

import com.valito.rickmortyapp.data.remote.ApiService
import com.valito.rickmortyapp.data.repository.RepositoryImpl
import com.valito.rickmortyapp.domain.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.InternalAPI
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
//                    parameters.append("key","")
                }
            }

        }
    }
    factoryOf(::ApiService)
//    factory<ApiService> { get(ApiService::class) }

    factory<Repository> { RepositoryImpl(get()) }
}

