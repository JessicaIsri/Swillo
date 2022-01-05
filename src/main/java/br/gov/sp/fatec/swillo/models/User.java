package br.gov.sp.fatec.swillo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "us_user")
public class User {
    private static final long serialVersionUID = 986589124772488369L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id", columnDefinition = "serial")
    private Long id;

//    @JsonView({View.User.class, View.UserComplete.class})
    @Column(name = "us_name")
    private String name;

//    @JsonView({View.User.class, View.UserComplete.class})
    @Column(name = "us_email")
    private String email;

//    @JsonView({View.User.class, View.UserComplete.class})
    @Column(name = "us_password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "uau_usuario_autorizacao",
            joinColumns = { @JoinColumn(name = "usr_id") },
            inverseJoinColumns = { @JoinColumn(name = "aut_id") })
    private Set<Autorization> autorizations;

}
