package com.vw.imageprocessing.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "user_profile")
public class UserModel {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String userName;

    private String userPasswod;
    
    

}
