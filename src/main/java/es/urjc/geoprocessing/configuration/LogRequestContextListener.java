package es.urjc.geoprocessing.configuration;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import java.util.UUID;

@Configuration
@WebListener
public class LogRequestContextListener extends RequestContextListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        super.requestInitialized(event);
        System.setProperty("isThreadContextMapInheritable", "true");
        System.setProperty("log4j2.isThreadContextMapInheritable", "true");
        ThreadContext.put("requestId", UUID.randomUUID().toString());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        super.requestDestroyed(event);
        ThreadContext.clearAll();
    }
}
