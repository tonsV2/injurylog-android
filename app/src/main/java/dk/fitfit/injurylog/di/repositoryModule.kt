package dk.fitfit.injurylog.di

import dk.fitfit.injurylog.repository.InjuryRepository
import org.koin.dsl.module

@JvmField
val repositoryModule = module {
    single { InjuryRepository(get(), get()) }
}
