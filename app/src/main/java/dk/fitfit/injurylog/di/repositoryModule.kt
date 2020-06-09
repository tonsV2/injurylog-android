package dk.fitfit.injurylog.di

import dk.fitfit.injurylog.repository.InjuryRepository
import dk.fitfit.injurylog.repository.TagRepository
import org.koin.dsl.module

@JvmField
val repositoryModule = module {
    single { InjuryRepository(get(), get(), get(), get()) }
    single { TagRepository(get(), get()) }
}
