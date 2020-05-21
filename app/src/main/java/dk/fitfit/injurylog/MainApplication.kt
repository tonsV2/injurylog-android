package dk.fitfit.injurylog

import android.app.Application
import dk.fitfit.injurylog.di.apiModule
import dk.fitfit.injurylog.di.databaseModule
import dk.fitfit.injurylog.di.repositoryModule
import dk.fitfit.injurylog.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(databaseModule, apiModule, viewModule, repositoryModule)
        }
    }
}
