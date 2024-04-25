package io.codlibs.springai.chats;

import io.codlibs.springai.clients.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chats")
    public String ask(@RequestParam(name = "prompt", defaultValue = "Joke of the day") String prompt,
                      @RequestParam(name = "service", defaultValue = "openai") String service) {
        return chatService.ask(prompt, service);
    }
}
