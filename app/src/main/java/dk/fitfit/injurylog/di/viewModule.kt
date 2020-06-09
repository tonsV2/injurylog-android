package dk.fitfit.injurylog.di

import dk.fitfit.injurylog.ui.InjuriesViewModel
import dk.fitfit.injurylog.ui.TagsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val viewModule = module {
    viewModel { InjuriesViewModel(get()) }
    viewModel { TagsViewModel(get()) }
}
