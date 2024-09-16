package com.sonu.notes.core.data.repository

import com.sonu.notes.core.data.local.NoteDb
import com.sonu.notes.core.data.mapper.toNoteEntityForDelete
import com.sonu.notes.core.data.mapper.toNoteEntityForInsert
import com.sonu.notes.core.data.mapper.toNoteItem
import com.sonu.notes.core.domain.model.NoteItem
import com.sonu.notes.core.domain.repository.NoteRepository


class NoteRepositoryImpl(
    noteDb: NoteDb
) : NoteRepository {

    private val noteDao = noteDb.noteDao

    override suspend fun upsertNote(noteItem: NoteItem) {
        noteDao.upsertNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        noteDao.deleteNoteEntity(noteItem.toNoteEntityForDelete())
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteDao.getAllNoteEntities().map { it.toNoteItem() }
    }
}












