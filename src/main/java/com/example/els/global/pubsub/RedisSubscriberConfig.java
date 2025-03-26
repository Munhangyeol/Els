package com.example.els.global.pubsub;

import com.example.els.global.pubsub.KeywordSubscriber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisSubscriberConfig {
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisConnectionFactory connectionFactory, KeywordSubscriber keywordSubscriber) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(keywordSubscriber, new ChannelTopic("keyword-update"));
        return container;
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic("keyword-update");
    }
}
