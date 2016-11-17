package project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Make file directory defined in KSHIMGPATH accessable on /images/ on the webhost
        registry.addResourceHandler("/images/**").addResourceLocations("file:///" + System.getenv("KSHIMGPATH"));
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

}
