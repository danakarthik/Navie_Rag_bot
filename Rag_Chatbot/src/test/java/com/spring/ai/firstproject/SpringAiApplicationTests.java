package com.spring.ai.firstproject;

import com.spring.ai.firstproject.Service.ChatService;
import com.spring.ai.firstproject.helper.Helper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAiApplicationTests {

    @Autowired
    private ChatService chatService;

	@Test
	void contextLoads() {
        System.out.println("database has started running");
        this.chatService.SaveData(Helper.getData());
        System.out.println("data stored in vector database");
	}

}
