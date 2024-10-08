package com.valito.rickmortyapp.di

import com.valito.rickmortyapp.domain.use_case.GetRandomCharacterUC
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetRandomCharacterUC)
//    factory<GetRandomCharacterUC> { (GetRandomCharacterUC(get())) }
}