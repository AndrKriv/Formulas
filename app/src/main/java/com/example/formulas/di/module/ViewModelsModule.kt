package com.example.formulas.di.module

import androidx.lifecycle.ViewModel
import com.example.formulas.addformulas.mvvm.presentation.viewmodel.AddFormulasViewModel
import com.example.formulas.addformulas.mvvm.presentation.viewmodel.AddThemesViewModel
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.InfoViewModel
import com.example.formulas.di.key.ViewModelKey
import com.example.formulas.showformulas.mvvm.presentation.viewmodel.PasswordViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

    @IntoMap
    @Binds
    @ViewModelKey(InfoViewModel::class)
    abstract fun bindInfoViewModel(infoViewModel: InfoViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(PasswordViewModel::class)
    abstract fun bindPasswordVM(passwordViewModel: PasswordViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(AddThemesViewModel::class)
    abstract fun bindAddThemeVM(addThemesViewModel: AddThemesViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(AddFormulasViewModel::class)
    abstract fun bindAddFormulasVM(addFormulasViewModel: AddFormulasViewModel): ViewModel
}