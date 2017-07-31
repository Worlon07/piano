package com.company.my.stackexchange.config;

import com.company.my.stackexchange.controller.ControllerPackage;
import com.company.my.stackexchange.service.impl.ServicePackage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring mvc configuration for Full Stack Live Coding Exercise
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {ControllerPackage.class,
        ServicePackage.class})
public class WebMvcConfig {
    /**
     * View resolver to resolve view name which return view controllers
     *
     * @return View resolver
     */
    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}