package com.user.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User
{
    @Id
    private String userId;
    //@Column(name="user_name",unique = true,length = 10)
    private String name;
    private String password;
    private String email;
    private String about;
}
