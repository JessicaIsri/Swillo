package br.gov.sp.fatec.swillo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean forgetPassword;
    private String newPassword;
    private String token;
    private String autorizacao;
}
