package com.example.formulas.di.module

import android.app.Application
import androidx.room.Room
import com.example.formulas.database.dao.ClassesDao
import com.example.formulas.database.dao.FormulasDao
import com.example.formulas.database.dao.ThemesDao
import com.example.formulas.database.db.FormulasDatabase
import com.example.formulas.showformulas.util.Constants
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideFormulasDao(database: FormulasDatabase): FormulasDao =
        database.formulasDao()

    @Provides
    @Singleton
    fun provideThemesDao(database: FormulasDatabase): ThemesDao =
        database.themesDao()

    @Provides
    @Singleton
    fun provideClassesDao(database: FormulasDatabase): ClassesDao =
        database.classesDao()

    @Singleton
    @Provides
    fun providesDatabase(application: Application): FormulasDatabase =
        Room
            .databaseBuilder(
                application.applicationContext,
                FormulasDatabase::class.java,
                Constants.DATABASE_NAME
            )
            //.createFromAssets()
            .build()
}
