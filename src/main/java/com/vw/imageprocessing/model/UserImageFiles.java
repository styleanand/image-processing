package com.vw.imageprocessing.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_image_repo ")
public class UserImageFiles extends AuditModel{

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotNull
    @Size(max = 100)
    private String imageFileName;

    @NotNull
    @Size(max = 100)
    private String imageFileType;
    
    @NotNull
    @Lob
    private byte[] imageData;
    
    
    @NotNull
    @Size(max = 100)
    private String imageStatus;
    
    @NotNull
    @Size(max = 100)
    private String userAuthorized;
    

    public UserImageFiles() {

    }


	public UserImageFiles(Long id, @NotNull @Size(max = 100) String imageFileName,
			@NotNull @Size(max = 100) String imageFileType, byte[] imageData,
			@NotNull @Size(max = 100) String imageStatus, @NotNull @Size(max = 100) String userAuthorized) {
		super();
		this.id = id;
		this.imageFileName = imageFileName;
		this.imageFileType = imageFileType;
		this.imageData = imageData;
		this.imageStatus = imageStatus;
		this.userAuthorized = userAuthorized;
	}

	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userprofile_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserProfile userProfile;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImageFileName() {
		return imageFileName;
	}


	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}


	public String getImageFileType() {
		return imageFileType;
	}


	public void setImageFileType(String imageFileType) {
		this.imageFileType = imageFileType;
	}


	public byte[] getImageData() {
		return imageData;
	}


	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}


	public String getImageStatus() {
		return imageStatus;
	}


	public void setImageStatus(String imageStatus) {
		this.imageStatus = imageStatus;
	}


	public String getUserAuthorized() {
		return userAuthorized;
	}


	public void setUserAuthorized(String userAuthorized) {
		this.userAuthorized = userAuthorized;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
}
