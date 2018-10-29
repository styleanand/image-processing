package com.vw.imageprocessing.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vw.imageprocessing.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
