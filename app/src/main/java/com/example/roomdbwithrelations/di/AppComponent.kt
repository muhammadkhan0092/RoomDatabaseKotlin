package com.example.roomdbwithrelations.di

import android.content.Context
import com.example.roomdbwithrelations.MainActivity
import com.example.roomdbwithrelations.modules.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DatabaseModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface FACTORY{
        fun create(
            @BindsInstance
            context: Context
        ) : AppComponent
    }
}