package project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Properties;
import java.io.InputStream;
import java.lang.Exception;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	private Properties stillingar;

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// Load the settings from path.cfg
		try {
    		stillingar = new Properties();
    		InputStream asdf = getClass().getResourceAsStream("/path.cfg");
			stillingar.load(asdf);
			asdf.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// Make file directory defined in path.cfg accessable on /images/ on the webhost
        registry.addResourceHandler("/images/**").addResourceLocations("file:///" + stillingar.getProperty("filePath"));

    }

}
