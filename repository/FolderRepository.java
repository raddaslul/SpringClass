package com.sparta.selectshop2.repository;

import com.sparta.selectshop2.model.Folder;
import com.sparta.selectshop2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Long> {
     List<Folder> findAllByUser(User user);
     boolean existsByUserAndName(User user, String name);
}