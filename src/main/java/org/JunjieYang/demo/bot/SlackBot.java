package org.JunjieYang.demo.bot;

import org.JunjieYang.demo.model.Report;
import org.JunjieYang.demo.dao.ReportRepository;
import java.util.Arrays;
import java.util.regex.Matcher;

import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;


@Component
public class SlackBot extends Bot{
    private static final Logger logger = LoggerFactory.getLogger(SlackBot.class);


    @Autowired
    ReportRepository reportRepository;
    @Value("${slackBotToken")
    private String slackToken;

    @Override
    public String getSlackToken(){
        return slackToken;
    }

    @Override
    public Bot getSlackBot(){
        return this;
    }

    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
    public void onReceiveDM(WebSocketSession session, Event event) {
        reply(session, event, new Message("Hi, I am " + slackService.getCurrentUser().getName()));
    }
    @Controller(events = EventType.MESSAGE, pattern = "*")
    public void onReceiveMessage(WebSocketSession session, Event event, Matcher matcher) {
        if(!matcher.group(0).isEmpty()) {
            Report report = new Report(event.getUserId(),matcher.group(0));
            reportRepository.save(report);
            reply(session, event, new Message("ABCDE."));
        }
    }


}
