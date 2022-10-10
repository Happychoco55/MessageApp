package dev.terry.repos;

import dev.terry.entities.AppUser;
import dev.terry.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
}
