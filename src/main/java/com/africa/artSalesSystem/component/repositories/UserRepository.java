package com.africa.artSalesSystem.component.repositories;

import com.africa.artSalesSystem.component.models.ArtSystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<ArtSystemUser, Long> {
    Optional<ArtSystemUser> findByEmail(String email);
}
