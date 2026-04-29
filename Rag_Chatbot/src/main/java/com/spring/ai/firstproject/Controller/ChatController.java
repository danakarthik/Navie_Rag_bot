package com.spring.ai.firstproject.Controller;

import com.spring.ai.firstproject.Service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class ChatController {
    private ChatService chatService;

    public  ChatController(ChatService chatService){
        this.chatService=chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q") String message,
        @RequestHeader("userId") String userId){

        return ResponseEntity.ok(chatService.chat(message,userId));

    }
    @GetMapping("/stream-chat")
    public ResponseEntity<Flux<String>> streamChat(
            @RequestParam(value = "q") String query
    ){
        return ResponseEntity.ok(chatService.streamChat(query));
    }
}
