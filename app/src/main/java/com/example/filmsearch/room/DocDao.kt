package com.example.filmsearch.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.filmsearch.model.Doc
import com.example.filmsearch.model.Movies

@Dao
interface DocDao {

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addHuman(doc:List<Doc>)

    @Update
    suspend fun updateHuman(doc: Doc)




    @Delete
  suspend  fun deleteById(doc: Doc)

    @Query("SELECT * FROM movies ORDER BY id DESC")
    fun getAllHuman():LiveData<MutableList<Doc>>

}