package dk.fitfit.injurylog.di

import dk.fitfit.injurylog.ui.InjuriesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val viewModule = module {
    viewModel { InjuriesViewModel(get()) }
}
