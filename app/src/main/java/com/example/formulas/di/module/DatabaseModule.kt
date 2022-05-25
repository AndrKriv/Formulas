package com.example.formulas.di.module

import android.content.Context
import androidx.room.Room
import com.example.formulas.core.Constants
import com.example.formulas.data.database.FormulasDatabase
import com.example.formulas.data.database.dao.ClassesDao
import com.example.formulas.data.database.dao.FormulasDao
import com.example.formulas.data.database.dao.ThemesDao
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
    fun providesDatabase(context: Context): FormulasDatabase =
        Room
            .databaseBuilder(
                context.applicationContext,
                FormulasDatabase::class.java,
                Constants.DATABASE_NAME
            )
            .createFromAsset("formulas.db")
            .build()
}
