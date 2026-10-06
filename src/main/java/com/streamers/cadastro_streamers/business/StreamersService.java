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

    public Streamers buscarStreamersPorNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public void deletarStreamersPorNome(String nome)
    {
        repository.deleteByNome(nome);
    }

    public void atualizarStreamersPorId(Integer id, Streamers streamers)
    {
        Streamers streamersEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Streamer não encontrado"));
        Streamers streamersAtualizado = Streamers.builder()
                .nome(streamers.getNome() != null ? streamers.getNome() : streamersEntity.getNome())
                .conteudo(streamers.getConteudo() != null ? streamers.getConteudo() : streamersEntity.getConteudo())
                .plataforma(streamers.getPlataforma() != null ? streamers.getPlataforma() : streamersEntity.getPlataforma())
                .seguidores(streamers.getSeguidores() != null ? streamers.getSeguidores() : streamersEntity.getSeguidores())
                .id(streamersEntity.getId())
                .build();

        repository.saveAndFlush(streamersAtualizado);
    }
}
