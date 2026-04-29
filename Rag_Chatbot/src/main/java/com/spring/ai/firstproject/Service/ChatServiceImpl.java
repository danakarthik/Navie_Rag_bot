package com.spring.ai.firstproject.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;


@Service
public class ChatServiceImpl implements ChatService {


    @Value("classpath:/Prompts/system-prompts.st")
    private Resource systemMesssage;

    @Value("classpath:/Prompts/user-prompts.st")
    private Resource userMessage;

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private ChatClient chatClient;
    private VectorStore vectorStore;

    public ChatServiceImpl(ChatClient chatClient,VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.vectorStore=vectorStore;
    }
    @Override
     public String chat(String query, String userId) {
        SearchRequest searchRequest = SearchRequest.builder()
                .topK(3)
                .similarityThreshold(0.2)
                .query(query)
                .build();
//        List<Document> similaritySearch = this.vectorStore.similaritySearch(searchRequest);
//        List<String> list = similaritySearch.stream().map(Document::getText).toList();
//        String ContextData = String.join(",", list);
//        logger.info("context data: {}",ContextData);

        return this.chatClient
                .prompt()
                .advisors(QuestionAnswerAdvisor.builder(vectorStore).build())
                .user(user->user.text(this.userMessage)
                        .param("query",query))
                .call()
                .content();
    }

    @Override
    public Flux<String> streamChat(String query) {
        return this.chatClient
                .prompt()
                .system(system->system.text(this.systemMesssage))
                .user(user->user.text(this.userMessage).param("concept",query))
                .stream()
                .content();
    }

    @Override
    public void SaveData(List<String> list) {
        List<Document> documentList = list.stream().map(Document::new).toList();
       vectorStore.add(documentList);

    }
}
