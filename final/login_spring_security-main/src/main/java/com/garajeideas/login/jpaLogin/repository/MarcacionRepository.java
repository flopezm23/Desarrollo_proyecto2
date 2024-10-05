package com.garajeideas.login.jpaLogin.repository;

import com.garajeideas.login.jpaLogin.entity.Marcacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcacionRepository extends JpaRepository<Marcacion, Long> {
}
