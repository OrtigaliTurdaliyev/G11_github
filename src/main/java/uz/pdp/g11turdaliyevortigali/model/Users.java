package uz.pdp.g11turdaliyevortigali.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Users {
    private Integer id;
    private String fullName;
    private String password;
}
