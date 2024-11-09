package io.github.xxyopen.novel.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * ShardingSphere Configuration
 * Control ShardingSphere
 */
@Configuration
@EnableAutoConfiguration(exclude = {
    org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration.class
})
@ConditionalOnProperty(
    prefix = "spring.shardingsphere",
    name = {"enabled"},
    havingValue = "false"
)
public class ShardingSphereConfiguration {

}
