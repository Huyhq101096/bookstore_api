package book.store.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRq {

    @NotBlank(message = "Email cannot be left blank")
    private String email;

    @NotBlank(message = "Password cannot be left blank")
    private String password;

    @NotBlank(message = "phone cannot be left blank")
    private String phone;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;


}
