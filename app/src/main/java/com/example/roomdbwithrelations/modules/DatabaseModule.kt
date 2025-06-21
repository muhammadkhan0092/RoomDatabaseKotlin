package com.example.roomdbwithrelations.modules

import android.content.Context
import androidx.room.Room
import com.example.roomdbwithrelations.db.SchoolDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun getDb(context: Context) : SchoolDb{
        return Room.databaseBuilder(
            context,
            SchoolDb::class.java,
            "SchoolDb"
        ).build()
    }
}