package com.example.formulas.di

import android.content.Context
import com.example.formulas.app.App
import com.example.formulas.app.MainActivity
import com.example.formulas.di.module.DatabaseModule
import com.example.formulas.di.module.ViewModelFactoryModule
import com.example.formulas.di.module.ViewModelsModule
import com.example.formulas.presentation.classes.ByClassesFragment
import com.example.formulas.presentation.info.InfoFragment
import com.example.formulas.presentation.start.StartFragment
import com.example.formulas.presentation.theme.ByThemesFragment
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
    fun inject(byThemes: ByThemesFragment)
    fun inject(byClasses: ByClassesFragment)
    fun inject(infoFragment: InfoFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(app: App)
}