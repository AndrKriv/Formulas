package com.example.formulas.di.module

import androidx.lifecycle.ViewModel
import com.example.formulas.di.ViewModelKey
import com.example.formulas.presentation.info.InfoViewModel
import com.example.formulas.presentation.theme.ByThemesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {
    @IntoMap
    @Binds
    @ViewModelKey(ByThemesViewModel::class)
    abstract fun bindByThemeViewModel(byThemesViewModel: ByThemesViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(InfoViewModel::class)
    abstract fun bindInfoViewModel(infoViewModel: InfoViewModel): ViewModel
}