package spring.config;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationContextProvider implements ApplicationContextAware {
	
	@Autowired
    private static ApplicationContext context;
 
    public ApplicationContext getApplicationContext() {
        return context;
    }
 
    @Override
    public void setApplicationContext(ApplicationContext ctx) {
        context = ctx;
    }
}