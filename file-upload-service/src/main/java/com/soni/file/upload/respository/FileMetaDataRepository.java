package com.soni.file.upload.respository;


import com.soni.file.upload.entity.FileMetaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileMetaDataRepository extends JpaRepository<FileMetaData,Integer> {
    Optional<FileMetaData> findByName(String fileName);
}
