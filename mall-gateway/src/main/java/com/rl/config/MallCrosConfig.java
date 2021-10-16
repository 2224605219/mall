package com.rl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/30 16:07
 */
@Configuration
public class MallCrosConfig {

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        //1、配置跨域
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");//支持的请求方式
        corsConfiguration.addAllowedOriginPattern("*");//支持的来源 新版本里面用该api 来版本里面用addAllowedOrigin
        corsConfiguration.setAllowCredentials(true);//跨域请求可以携带cookie

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }



}
