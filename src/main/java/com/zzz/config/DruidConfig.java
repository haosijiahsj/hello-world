package com.zzz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * druid连接池配置
 */
@Slf4j
@Configuration
public class DruidConfig {

    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private static final String DRUID_URL = "/druid/*";
    private static final String URL_PATTERNS = "/*";
    private static final String LOG_SLOW_SQL = "true";
    private static final String EXCLUSIONS = "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*";
    private static final String PROFILE_ENABLE = "true";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        log.debug("init druid data source !");
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean<StatViewServlet> reg = new ServletRegistrationBean<>();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings(DRUID_URL);
        reg.addInitParameter("loginUsername", username);
        reg.addInitParameter("loginPassword", password);
        reg.addInitParameter("logSlowSql", LOG_SLOW_SQL);
        return reg;
    }

    @Bean
    public FilterRegistrationBean druidFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns(URL_PATTERNS);
        filterRegistrationBean.addInitParameter("exclusions", EXCLUSIONS);
        filterRegistrationBean.addInitParameter("profileEnable", PROFILE_ENABLE);
        return filterRegistrationBean;
    }

}