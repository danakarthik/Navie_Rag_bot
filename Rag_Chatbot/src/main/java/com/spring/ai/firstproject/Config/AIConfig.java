package com.spring.ai.firstproject.Config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;

import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AIConfig {

//    @Bean
//    public ChatMemory chatMemory(JdbcChatMemoryRepository jdbcChatMemoryRepository){
//        return MessageWindowChatMemory.builder().chatMemoryRepository(jdbcChatMemoryRepository)
//                .maxMessages(10)
//                .build();
//    }
@Bean
public ChatMemory chatMemory(){
    InMemoryChatMemoryRepository chatMemoryRepository = new InMemoryChatMemoryRepository();
    return MessageWindowChatMemory.builder().maxMessages(10).chatMemoryRepository(chatMemoryRepository)
            .build();
}

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, ChatMemory chatMemory  ){
        MessageChatMemoryAdvisor messageChatMemoryAdvisor = MessageChatMemoryAdvisor.builder(chatMemory).build();
        return builder
                .defaultAdvisors(messageChatMemoryAdvisor,new SimpleLoggerAdvisor(),new SafeGuardAdvisor(List.of("games")))
                .defaultSystem("you are an  helpful coding assistant. you are expert in coding")
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("gpt-4o-mini")
                        .temperature(0.3)
                        .maxTokens(200)
                        .build()
                )
                .build();

    }
}
