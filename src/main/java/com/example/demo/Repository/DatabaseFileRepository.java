package com.example.demo.Repository;

import com.example.demo.Model.DatabaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, Integer>{


}
