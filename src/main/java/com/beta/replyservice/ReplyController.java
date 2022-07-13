package com.beta.replyservice;

import com.beta.replyservice.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("/reply")
    public ReplyMessage replying() {
        return new ReplyMessage("Message is empty");
    }

   /* @GetMapping("/reply/{message}")
    public ReplyMessage replying(@PathVariable String message) {
        return new ReplyMessage(message);
    }*/


    @GetMapping("/reply/{message}")
    public ReplyMessage operation(@PathVariable String message) {

        String result = replyService.operation(message);

        return new ReplyMessage(result);

    }

}