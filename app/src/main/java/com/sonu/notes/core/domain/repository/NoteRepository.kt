package com.sonu.notes.core.domain.repository

import com.sonu.notes.core.domain.model.NoteItem


interface NoteRepository {

    suspend fun upsertNote(noteItem: NoteItem)

    suspend fun deleteNote(noteItem: NoteItem)

    suspend fun getAllNotes(): List<NoteItem>

}


















