package com.mogikanensoftware.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        // disable Hazelcast Auto Configuration, and use JCache configuration for the member example
        HazelcastAutoConfiguration.class
})
@EnableCaching
public class SpringBootHazelcastJcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHazelcastJcacheApplication.class, args);
	}
}
