package com.spring.ai.firstproject.Service;

import reactor.core.publisher.Flux;

import java.util.List;


public interface ChatService {

    String chat(String query, String userId);

    Flux<String> streamChat(String query);
    void SaveData(List<String> lsit);
}
