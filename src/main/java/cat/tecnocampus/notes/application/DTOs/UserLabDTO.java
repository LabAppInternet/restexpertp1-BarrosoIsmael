package cat.tecnocampus.notes.application.DTOs;

import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class UserLabDTO {

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
    @NotBlank(message = "The name cannot be blank")
    @Size(min = 3, message = "The name must be at least 3 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "The name must begin with a capital letter")
    private String name;

    @Size(min = 3, message = "second name must be at least 3 characters")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*$", message = "Middle name must begin with a capital letter")
    private String secondName;
    @Email(message = "the email address is not valid")
    @NotBlank(message = "Email address cannot be blank")
    private String email;

    private final Map<String, NoteLabDTO> ownedNotes;

    public UserLabDTO() {
        ownedNotes = new HashMap<String, NoteLabDTO>();
    }

    public UserLabDTO(String username, String name, String secondName, String email) {
        ownedNotes = new HashMap<>();

        this.username = username;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public List<NoteLabDTO> getOwnedNotes() {
        return new ArrayList<NoteLabDTO>(ownedNotes.values());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwnedNotes(List<NoteLabDTO> ownedNotes) {
        this.ownedNotes.clear();
        ownedNotes.forEach(note -> this.ownedNotes.put(note.getTitle(), note));
    }
}