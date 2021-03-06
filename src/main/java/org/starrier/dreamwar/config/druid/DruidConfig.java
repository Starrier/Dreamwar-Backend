package org.starrier.dreamwar.config.druid;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Configuration of Druid </p>
 *
 * @author Starrier
 * @date 2018/11/9.
 */
@Slf4j
@Configuration
public class DruidConfig {

    /**
     * {@link ServletRegistrationBean} Provide class to register.
     * 1. add initialize params.
     * 2. whether reset or not.
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        log.info("servletRegistrationBean config start");
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        servletRegistrationBean.addInitParameter("resetEnable", "fase");
        return servletRegistrationBean;
    }

    /**
     * <p>Register</p>
     * <p><filterRegistrationBean/p>
     * 1. Add Filter rules.
     * 2. 添加不需要忽略的信息格式
     *
     * @return filterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter2() {
        log.info("filterRegistrationBean configure start.");
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

