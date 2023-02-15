package com.example.filmsearch.room

import android.content.Context
import androidx.room.*
import com.example.filmsearch.converter.*
import com.example.filmsearch.model.Doc
import com.example.filmsearch.model.ReleaseYear

@Database(entities = [Doc::class], version = 5)
//listOf(DocConverter::class
@TypeConverters(DocConverter::class,NamesConverter::class, ReleaseYearConverter::class,ItemsYearConverter::class,ExternalIdConverter::class,LogoConverters::class
,PosterTypeConverter::class,RatingConverters::class,VotesConverter::class,WatchabilityConverter::class)
abstract class DocDatabase: RoomDatabase() {
    abstract fun getDocDao(): DocDao

    companion object {
        @Volatile
        private var instance: DocDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:

        synchronized(LOCK) {

            instance ?:  createDatabase(context).also { instance =it }

        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DocDatabase::class.java,
                "film_db"
            ).build()
    }
}