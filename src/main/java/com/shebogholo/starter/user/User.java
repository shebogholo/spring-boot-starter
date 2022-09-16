package com.shebogholo.starter.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @JsonIgnore
    @NonNull
    private String password;
}

// @Entity(name = "users")
//public class User {
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @Column(nullable = false, length = 50)
//    private String firstName;
//
//    @Column(nullable = false, length = 50)
//    private String lastName;
//
//    @Column(nullable = false, length = 120)
//    private String email;
//
//    @Column(nullable = false, length = 50)
//    private String firstLineOfAddress;
//
//    @Column(length = 50)
//    private String secondLineOfAddress;
//
//    @Column(nullable = false, length = 50)
//    private String town;
//
//    @Column(nullable = false, length = 10)
//    private String postCode;
//
//    // Getters and Setters (Omitted for brevity)
//}