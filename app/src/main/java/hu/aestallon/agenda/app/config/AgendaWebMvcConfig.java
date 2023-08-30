package hu.aestallon.agenda.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

@Configuration
public class AgendaWebMvcConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/**")
        .addResourceLocations("classpath:/static/")
        .resourceChain(true)
        .addResolver(new PathResourceResolver() {
          @Override
          protected Resource getResource(String resourcePath, Resource location)
          throws IOException {
            // if a client requests a resource which does not exist or is not readable, retrieve
            // the index.html and offer it back up: this way Vue can sort out the routing the
            // client should follow:
            Resource resource = location.createRelative(resourcePath);
            return resource.exists() && resource.isReadable()
                ? resource
                : new ClassPathResource("/static/index.html");
          }
        });
  }

}
