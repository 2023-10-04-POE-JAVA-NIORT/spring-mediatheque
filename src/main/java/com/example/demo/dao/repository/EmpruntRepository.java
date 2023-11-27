package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Adherent;
import com.example.demo.dao.entity.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Integer> {

    List<Emprunt> findAllByAdherent(Adherent adherent);

    int countByAdherent(Adherent adherent);

    @Query(value = "SELECT count(*) FROM emprunts e WHERE adherent_id = :id", nativeQuery = true)
    int countNativeQuery(@Param("id") Integer adherentId);

    @Query(value = "SELECT count(e) FROM Emprunt e WHERE e.adherent = :adherent")
    int countQuery(@Param("adherent") Adherent adherent);
}