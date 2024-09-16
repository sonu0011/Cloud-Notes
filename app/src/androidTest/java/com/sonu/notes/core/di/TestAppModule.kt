package com.sonu.notes.core.di

import android.app.Application
import androidx.room.Room
import com.sonu.notes.add_note.domain.use_case.SearchImages
import com.sonu.notes.add_note.domain.use_case.UpsertNote
import com.sonu.notes.core.data.local.NoteDb
import com.sonu.notes.core.data.remote.api.ImagesApi
import com.sonu.notes.core.data.repository.FakeAndroidImagesRepository
import com.sonu.notes.core.data.repository.FakeAndroidNoteRepository
import com.sonu.notes.core.domain.repository.ImagesRepository
import com.sonu.notes.core.domain.repository.NoteRepository
import com.sonu.notes.note_list.domain.use_case.DeleteNote
import com.sonu.notes.note_list.domain.use_case.GetAllNotes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDb(application: Application): NoteDb {
        return Room.inMemoryDatabaseBuilder(
            application,
            NoteDb::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(): NoteRepository {
        return FakeAndroidNoteRepository()
    }

    @Provides
    @Singleton
    fun provideGetAllNotesUseCase(
        noteRepository: NoteRepository
    ): GetAllNotes {
        return GetAllNotes(noteRepository)
    }


    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(
        noteRepository: NoteRepository
    ): DeleteNote {
        return DeleteNote(noteRepository)
    }

    @Provides
    @Singleton
    fun provideUpsertNoteUseCase(
        noteRepository: NoteRepository
    ): UpsertNote {
        return UpsertNote(noteRepository)
    }


    @Provides
    @Singleton
    fun provideImageApi(): ImagesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ImagesApi.BASE_URL)
            .build()
            .create(ImagesApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImagesRepository(): ImagesRepository {
        return FakeAndroidImagesRepository()
    }

    @Provides
    @Singleton
    fun provideSearchImagesUseCase(
        imagesRepository: ImagesRepository
    ): com.sonu.notes.add_note.domain.use_case.SearchImages {
        return com.sonu.notes.add_note.domain.use_case.SearchImages(imagesRepository)
    }

}























