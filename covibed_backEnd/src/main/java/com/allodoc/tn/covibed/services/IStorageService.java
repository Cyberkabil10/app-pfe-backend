package com.allodoc.tn.covibed.services;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {

    void init();

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    Object storeOrgImage(MultipartFile file, long orgID)throws Exception;

    Object storeDctImage(MultipartFile file, long userID) throws IOException;

}