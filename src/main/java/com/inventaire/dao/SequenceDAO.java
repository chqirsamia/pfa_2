package com.inventaire.dao;

import com.inventaire.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SequenceDAO extends JpaRepository<Sequence,Integer> {
    @Override
    List<Sequence> findAll();
}
