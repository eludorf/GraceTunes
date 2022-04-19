package teksystems.capstone.formbean;

import lombok.*;
import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class SearchFormBean {

    @NotBlank(message ="Song name is required.")
    private String songName;
}
