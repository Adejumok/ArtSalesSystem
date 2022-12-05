package com.africa.artSalesSystem.repositories;

import com.africa.artSalesSystem.models.Art;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtRepository extends JpaRepository<Art, Long> {
    Optional<Art> findByArtTitle(String artTitle);
}
