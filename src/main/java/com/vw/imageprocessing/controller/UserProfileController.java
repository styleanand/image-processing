package com.vw.imageprocessing.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vw.imageprocessing.exception.ResourceNotFoundException;
import com.vw.imageprocessing.model.UserProfile;
import com.vw.imageprocessing.repository.UserProfileRepository;


@RestController
public class UserProfileController {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	
	@GetMapping("/userprofiles")
    public Page<UserProfile> getAllUserProfiles(Pageable pageable) {
        return userProfileRepository.findAll(pageable);
    }
	
	
    @PostMapping("/userprofiles")
    public UserProfile createPost(@Valid @RequestBody UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
    
    
    @PutMapping("/userProfiles/{userProfileId}")
    public UserProfile updatePost(@PathVariable Long userProfileId, @Valid @RequestBody UserProfile userProfileRequest) {
        return userProfileRepository.findById(userProfileId).map(userProfile -> {
        	userProfile.setUsername(userProfileRequest.getUsername());
        	userProfile.setUserpass(userProfileRequest.getUserpass());
        	userProfile.setLastname(userProfileRequest.getLastname());
        	userProfile.setFirstname(userProfileRequest.getFirstname());
        	userProfile.setStatus(userProfileRequest.getStatus());
        	userProfile.setEmailid(userProfileRequest.getEmailid());
        	userProfile.setContactno(userProfileRequest.getContactno());
            return userProfileRepository.save(userProfile);
        }).orElseThrow(() -> new ResourceNotFoundException("User Profile Id [ " + userProfileId + "]  not found"));
    }
    
    
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Long userProfileId) {
        return userProfileRepository.findById(userProfileId).map(userProfile -> {
        	userProfileRepository.delete(userProfile);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("User Profile Id  [ " + userProfileId + " ] not found ."));
    }

}
