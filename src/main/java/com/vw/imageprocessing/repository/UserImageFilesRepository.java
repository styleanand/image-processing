package com.vw.imageprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.imageprocessing.model.UserImageFiles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Repository
public interface UserImageFilesRepository extends JpaRepository<UserImageFiles, Long> {
	Page<UserImageFiles> findByUserProfileId(Long userprofileId, Pageable pageable);

}
