package com.inventaire.dao;

import com.inventaire.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandDAO extends JpaRepository<Command,Integer> {

    @Override
    List<Command> findAll();
}
