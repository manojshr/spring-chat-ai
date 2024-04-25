package io.codlibs.springai.clients;

import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    
    private final OpenAiChatClient openAIChatClient;

    private final VertexAiGeminiChatClient geminiChatClient;

    public ClientConfig(OpenAiChatClient openAIChatClient, VertexAiGeminiChatClient geminiChatClient) {
        this.openAIChatClient = openAIChatClient;
        this.geminiChatClient = geminiChatClient;
    }

    @Bean
    public ClientRegistry clientRegistry() {
        ClientRegistry clientRegistry = new ClientRegistry();
        clientRegistry.register("openai", openAIChatClient);
        clientRegistry.register("gemini", geminiChatClient);
        return clientRegistry;
    }
}
