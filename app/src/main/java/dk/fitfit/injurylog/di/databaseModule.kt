package dk.fitfit.injurylog.di

import android.content.Context
import androidx.room.Room
import dk.fitfit.injurylog.db.InjuryLogDatabase
import org.koin.dsl.module

@JvmField
val databaseModule = module {
    single { provideDatabase(get()) }
    single { get<InjuryLogDatabase>().injuryDao() }
    single { get<InjuryLogDatabase>().tagDao() }
    single { get<InjuryLogDatabase>().injuryTagsCrossReferenceDao() }
    single { get<InjuryLogDatabase>().imageReferenceDao() }
    single { get<InjuryLogDatabase>().injuryImageReferencesCrossRefDao() }
}

fun provideDatabase(context: Context) = Room
        .databaseBuilder(context, InjuryLogDatabase::class.java, "injury_log_database")
        .fallbackToDestructiveMigration()
        .build()
