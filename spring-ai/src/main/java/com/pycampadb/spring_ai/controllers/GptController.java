package com.pycampadb.spring_ai.controllers;

import com.pycampadb.spring_ai.dtos.PromptRequestDto;
import com.pycampadb.spring_ai.dtos.PromptResponseDto;
import com.pycampadb.spring_ai.services.GptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "gpt")
public class GptController {
    private final GptService gptService;

    public GptController(GptService gptService) {
        this.gptService = gptService;
    }
    @PostMapping(value = "/prompt")
    public ResponseEntity<?> promptOpenAI(@RequestBody PromptRequestDto requestDto){
        PromptResponseDto responseDto = gptService.sendRequestToOpenAI(requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
