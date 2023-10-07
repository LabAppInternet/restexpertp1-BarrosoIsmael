package cat.tecnocampus.notes.application.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;

public class NoteLabDTO {

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 3, max = 255, message = "The title must be between 3 and 255 characters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "The title must contain only letters")
    //pattern Verify that all characters in the title are uppercase or lowercase letters
    private String title;
    @NotBlank(message = "Content cannot be blank")
    private String content;

    private LocalDateTime dateCreation;

    private LocalDateTime dateEdit;

    private UserLabDTO owner;

    public NoteLabDTO() {
    }

    /*
    public UserLabDTO getOwner() {
        return owner;
    }

     */

    public void setOwner(UserLabDTO owner) {
        this.owner = owner;
    }

    public NoteLabDTO(String title, String content) {
        this.title = title;
        this.content = content;
        dateCreation = LocalDateTime.now();
        dateEdit = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDateEdit() {
        return dateEdit;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateEdit(LocalDateTime dateEdit) {
        this.dateEdit = dateEdit;
    }

}
