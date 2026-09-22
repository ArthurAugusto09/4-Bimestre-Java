package com.streamers.cadastro_streamers.business;

import com.streamers.cadastro_streamers.infrastructure.entitys.Streamers;
import com.streamers.cadastro_streamers.infrastructure.repository.StreamersRepository;
import org.springframework.stereotype.Service;

@Service
public class StreamersService {

    private final StreamersRepository repository;

    public StreamersService(StreamersRepository repository)
    {
        this.repository = repository;
    }

    public void salvarStreamers(Streamers streamers)
    {
        repository.saveAndFlush(streamers);
    }

    public Streamers buscarStreamersPorConteudo(String conteudo){
        return repository.findByConteudo(conteudo).orElseThrow(
                () -> new RuntimeException("Conteudo não encontrado")
        )
    }
}
