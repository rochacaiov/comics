package io.codigorocha.comics.adapter.repository;

import io.codigorocha.comics.adapter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
