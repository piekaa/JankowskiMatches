package pl.piekoszek.matches.equation.image;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ImageConfiguration {

    @Bean
    ImageService getImageService() {
        return new ImageServiceImplementation();
    }

}
