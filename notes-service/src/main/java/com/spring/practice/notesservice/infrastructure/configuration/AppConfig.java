package com.spring.practice.notesservice.infrastructure.configuration;

import com.spring.practice.notesservice.domain.repository.NoteRepository;
import com.spring.practice.notesservice.domain.service.NoteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public NoteService noteService(NoteRepository noteRepository) {
        return new NoteService(noteRepository);
    }


}
