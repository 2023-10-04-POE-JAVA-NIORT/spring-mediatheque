package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {
}