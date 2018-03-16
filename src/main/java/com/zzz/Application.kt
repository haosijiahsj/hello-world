package com.zzz

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ImportResource

/**
 * @author 胡胜钧
 * *
 * @date 2/25 0025.
 */
@Slf4j
@ImportResource("classpath:config/applicationContext.xml")
@SpringBootApplication(exclude = arrayOf(DataSourceAutoConfiguration::class))
open class Application

private val log = LoggerFactory.getLogger(Application::class.java)

fun main(args: Array<String>) {
    SpringApplicationBuilder()
            .sources(Application::class.java)
            .bannerMode(Banner.Mode.OFF)
            .run(*args)

    log.info("Application Startup Success !")
}


