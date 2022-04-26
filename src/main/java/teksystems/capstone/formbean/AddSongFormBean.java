package teksystems.capstone.formbean;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddSongFormBean {

    private Integer userId;

    private Integer id;

    @NotBlank(message="Song name is required.")
    private String songName;

    @NotBlank(message="Song time is required.")
    private String songTime;

    @NotBlank(message="Song key is required.")
    private String songKey;

    @NotBlank(message="Song genre is required.")
    private String songGenre;

    @NotBlank(message="Artist name is required.")
    private String artistName;

    @NotBlank(message="Album name is required.")
    private String albumName;
}