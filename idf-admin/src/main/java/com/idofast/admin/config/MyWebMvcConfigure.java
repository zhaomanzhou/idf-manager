package com.idofast.admin.config;

import com.idofast.admin.config.arguementresolver.CurUserMethodArgumentResolver;
import com.idofast.admin.config.interceptor.AuthorityInterceptor;
import com.idofast.admin.config.interceptor.CorsInterceptor;
import com.idofast.admin.config.interceptor.LoginInterceptor;
import com.idofast.admin.config.interceptor.RequestContextInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MyWebMvcConfigure implements WebMvcConfigurer
{

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private CorsInterceptor corsInterceptor;

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    @Autowired
    private RequestContextInterceptor requestContextInterceptor;
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(corsInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/user/**")
//                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/detail/token")
                .excludePathPatterns("/user/vcode/register")
                .excludePathPatterns("/user/vcode/resetPassword")
                .excludePathPatterns("/user/resetPassword/withVcode")
                .excludePathPatterns("/error/**")

                .addPathPatterns("/notice/**")
                .excludePathPatterns("/notice/detail/**")

                .addPathPatterns("/bundle/**")

                .addPathPatterns("/order/**")

                .addPathPatterns("/pay/**")
                .excludePathPatterns("/pay/callback")

                .addPathPatterns("/users/**")

                .addPathPatterns("/rechargelog/**")

                .addPathPatterns("/data/**")

                .addPathPatterns("/system/preference/**")

                .addPathPatterns("/node/**")

                .addPathPatterns("/subscription/**")
                .excludePathPatterns("/subscription/v2ray/**")


        ;

        registry.addInterceptor(requestContextInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(authorityInterceptor)
                .addPathPatterns("/**");

    }


    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
    }

    @Bean
    public CurUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurUserMethodArgumentResolver();
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }



    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
}
