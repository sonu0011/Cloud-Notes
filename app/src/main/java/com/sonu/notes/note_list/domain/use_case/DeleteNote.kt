package com.sonu.notes.note_list.domain.use_case

import com.sonu.notes.core.domain.model.NoteItem
import com.sonu.notes.core.domain.repository.NoteRepository


class DeleteNote(
    private val noteRepository: NoteRepository
) {

    suspend operator fun invoke(note: NoteItem) {
        noteRepository.deleteNote(note)
    }

}
















