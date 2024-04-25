package io.codlibs.springai.clients;

import org.springframework.ai.chat.ChatClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClientRegistry {
    private final Map<String, ChatClient> clients;

    public ClientRegistry() {
        this.clients = new HashMap<>();
    }

    public void register(String service, ChatClient client) {
        clients.put(service, client);
    }

    public Optional<ChatClient> get(String service) {
        return Optional.ofNullable(clients.get(service));
    }
}
