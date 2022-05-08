package com.example.formulas.di.component

import android.content.Context
import com.example.formulas.addformulas.mvvm.presentation.AddActivity
import com.example.formulas.addformulas.mvvm.presentation.ui.AddFormulasFragment
import com.example.formulas.addformulas.mvvm.presentation.ui.AddThemesFragment
import com.example.formulas.di.app.App
import com.example.formulas.di.module.DatabaseModule
import com.example.formulas.di.module.ViewModelFactoryModule
import com.example.formulas.di.module.ViewModelsModule
import com.example.formulas.showformulas.mvvm.presentation.MainActivity
import com.example.formulas.showformulas.mvvm.presentation.ui.InfoFragment
import com.example.formulas.showformulas.mvvm.presentation.ui.PasswordFragment
import com.example.formulas.showformulas.mvvm.presentation.ui.StartFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelsModule::class,
        ViewModelFactoryModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(startFragment: StartFragment)
    fun inject(infoFragment: InfoFragment)
    fun inject(passwordFragment: PasswordFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(app: App)
    fun inject(addFormulasFragment: AddFormulasFragment)
    fun inject(addThemesFragment: AddThemesFragment)
    fun inject(addActivity: AddActivity)
}