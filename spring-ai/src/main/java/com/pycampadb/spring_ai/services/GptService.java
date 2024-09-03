package com.pycampadb.spring_ai.services;

import com.pycampadb.spring_ai.dtos.PromptRequestDto;
import com.pycampadb.spring_ai.dtos.PromptResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GptService {
    private final ChatClient chatClient;

    public GptService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public PromptResponseDto sendRequestToOpenAI(PromptRequestDto requestDto){
        String response = chatClient.prompt()
                .user(requestDto.prompt())
                .call()
                .content();
        return new PromptResponseDto(response);
    }
}
