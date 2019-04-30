package bartboersma.springsecuritytryout.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusers")
    private Long id;

    @NotBlank(message = "username may not be empty")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "password may not be empty")
    @Column(name = "password")
    private String password;
}
