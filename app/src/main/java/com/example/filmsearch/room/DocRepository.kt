package com.example.filmsearch.room

import com.example.filmsearch.model.Doc

class DocRepository(private val db: DocDatabase) {

    suspend fun  addDoc(doc:List< Doc>)=db.getDocDao().addHuman(doc)
    suspend fun updateDoc(doc: Doc)=db.getDocDao().updateHuman(doc)
    fun getAllDoc()=db.getDocDao().getAllHuman()
   suspend  fun deleteDoc(doc: Doc)=db.getDocDao().deleteById(doc)

}