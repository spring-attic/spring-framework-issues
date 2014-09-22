package org.springframework.issues.config;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.protobuf.ExtensionRegistryInitializer;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;
import java.util.List;

@EnableWebMvc
@ComponentScan(basePackages = "org.springframework.issues")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        if (System.getProperty("fixed") == null) {
            System.err.println("==== Problem sample! ====");
            converters.add(new ProtobufHttpMessageConverter(new ExtensionRegistryInitializer() {
                @Override
                public void initializeExtensionRegistry(ExtensionRegistry registry) {

                }
            }));
        } else {
            System.err.println("==== Fixed sample! ====");
            converters.add(new ProtobufHttpMessageConverter(new ExtensionRegistryInitializer() {
                @Override
                public void initializeExtensionRegistry(ExtensionRegistry registry) {

                }
            }) {
                @Override
                protected void writeInternal(Message message, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                    outputMessage.getHeaders().set(X_PROTOBUF_SCHEMA_HEADER, message.getDescriptorForType().getFile().getName());
                    outputMessage.getHeaders().set(X_PROTOBUF_MESSAGE_HEADER, message.getDescriptorForType().getFullName());
                    FileCopyUtils.copy(message.toByteArray(), outputMessage.getBody());
                }
            });
        }
    }
}
