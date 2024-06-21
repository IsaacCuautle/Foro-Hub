package com.alurachallenges.foro_hub.controllers;

import com.alurachallenges.foro_hub.dto.topic.TopicData;
import com.alurachallenges.foro_hub.services.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topics")
public class TopicController
{

    @Autowired
    private TopicService service;

    // Publica un nuevo topico
    @PostMapping
    @Transactional
    public ResponseEntity setTopic(
            @RequestBody
            @Valid
            TopicData topic
    )
    {
        var response = service.publish(topic);

        Object responseBody = new Object() {
            public final int httpStatus = HttpStatus.OK.value();
            public final Object topic = response;
        };

        return ResponseEntity.ok(responseBody);
    }

    // TODO: Trae todos los topicos
    @GetMapping
    public void getTopics()
    {

    }

}
