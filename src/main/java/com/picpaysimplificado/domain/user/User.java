package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
@Getter // coming from lombok dependence
@Setter // coming from lombok dependence
@AllArgsConstructor // constructor that will receive all the classes parameters
@EqualsAndHashCode(of="id")
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generate ID automatically
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique=true)// here I am just saying that the document must be unique
    private  String document;

    @Column(unique=true)// here also I am saying that the email must be unique
    private String email ;
    private String password;
    private BigDecimal balance;// The value that the user have
    @Enumerated(EnumType.STRING) //I am just saying that one of these values represent one of the values i ut on Usertype enum (common or merchant)
    private UserType userType;

    public User (UserDTO data) throws Exception {
        this.firstName =data.firstName();
        this.lastName =data.lastName();
        this.balance =data.balance();
        this.userType = data.userType();
        this.password =data.password();
        this.document =data.document();
        this.email = data.email();

    }
}
