import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.util.FileSize

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.*

scan("60 seconds")
def appName = "hello-world"
def fileLogPattern = "%date{yyyy-MM-dd HH:mm:ss.SSS} -%5level [%15.15thread] %-40.40logger{39} : %msg%n"
def stdoutLogPattern = "%date{yyyy-MM-dd HH:mm:ss.SSS} -%highlight(%6level) [%15.15thread] %-40.40logger{39} : %msg%n"

appender("FILE", RollingFileAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = fileLogPattern
        charset = Charset.forName("UTF-8")
    }
    rollingPolicy(SizeAndTimeBasedRollingPolicy) {
        fileNamePattern = "../logs/${appName}-%d{yyyy-MM-dd}.%i.log"
        maxHistory = 30
        maxFileSize = FileSize.valueOf("64MB")
    }
    filter(ThresholdFilter) {
        level = INFO
    }
    prudent = true
}

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = stdoutLogPattern
        charset = Charset.forName("UTF-8")
    }
    filter(ThresholdFilter) {
        level = ALL
    }
}

root(INFO, ["FILE", "STDOUT"])
//logger("user", ALL)