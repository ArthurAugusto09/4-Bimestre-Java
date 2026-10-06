package com.streamers.cadastro_streamers.controller;

import com.streamers.cadastro_streamers.business.StreamersService;
import com.streamers.cadastro_streamers.infrastructure.entitys.Streamers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/streamers")
@RequiredArgsConstructor
public class StreamersController {

    private final StreamersService streamersService;

    @PostMapping
    public ResponseEntity<Void> salvarStreamers(@RequestBody Streamers streamers){
        streamersService.salvarStreamers(streamers);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Streamers> buscarStreamersPorNome(@RequestParam String nome){
        return ResponseEntity.ok(streamersService.buscarStreamersPorNome(nome));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarStreamersPorNome(@RequestParam String nome) {
        streamersService.deletarStreamersPorNome(nome);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarStreamersPorId(@RequestBody Streamers streamers, @RequestParam Integer id){
        streamersService.atualizarStreamersPorId(id, streamers);
        return ResponseEntity.ok().build();
    }
}
