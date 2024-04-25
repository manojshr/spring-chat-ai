package io.codlibs.springai.clients;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatService {
    private final ClientRegistry clientRegistry;

    public ChatService(ClientRegistry clientRegistry) {
        this.clientRegistry = clientRegistry;
    }

    public String ask(String prompt, String service) {
        return clientRegistry.get(service)
                .map(chatClient -> chatClient.call(prompt))
                .orElse("Error❌: Wrong Service Name");
    }
}
