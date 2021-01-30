import org.JunjieYang.demo.model.Report;
import org.JunjieYang.demo.dao.ReportRepository;
import java.util.Arrays;
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

    @Controller(events = {EventType.MESSAGE, EventType.DIRECT_MESSAGE})
    public void onReceiveDM(WebSocketSession session, Event event){
        //need to check what will we get for event
        System.out.println(event.getUserId());
        reply(session, event, new Message(slackService.getCurrentUser().getName()));
    }


}
