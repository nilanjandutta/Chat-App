package com.Abhay.ChatApplication.configuration;




import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.Abhay.ChatApplication.Handler.ChatWeb;



@Configuration
@EnableWebSocket
public class Socket implements WebSocketConfigurer
{
  private final static String endPoint="/chat" ;  

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
		webSocketHandlerRegistry.addHandler(getChatWebSocketHandler(),endPoint)
		.setAllowedOrigins("*");
		// TODO Auto-generated method stub
		
	}
	@Bean
	public WebSocketHandler getChatWebSocketHandler()
	{
		return new ChatWeb();
	}
}
