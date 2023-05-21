package com.example.socketPractice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket //webSocket 활성화
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/ws/chat").setAllowedOrigins("*");
        //웹 소켓이 접속하기 위한 엔트포인트를 /chat로 설정하고 CORS 설정을 추가한다.
        //이제 클라이언트가 ws://localhost:8080/chat로 커넥션을 연결하고 메세지 통신을 할 수 있게 한다.
    }
}
