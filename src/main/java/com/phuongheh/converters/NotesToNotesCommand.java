package com.phuongheh.converters;

import com.mongodb.lang.Nullable;
import com.phuongheh.commands.NotesCommand;
import com.phuongheh.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Override
    @Synchronized
    @Nullable
    public NotesCommand convert(Notes source) {
        if (source == null)
            return null;
        final NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNote());
        return notesCommand;
    }
}
