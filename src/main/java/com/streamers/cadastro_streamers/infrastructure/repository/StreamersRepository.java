package com.streamers.cadastro_streamers.infrastructure.repository;

import com.streamers.cadastro_streamers.infrastructure.entitys.Streamers;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreamersRepository extends JpaRepository<Streamers, Integer> {

    Optional<Streamers> findByNome(String nome);

    @Transactional
    void deleteByNome (String nome);
}
