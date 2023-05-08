package com.bne.core.config;

import lombok.extern.slf4j.Slf4j;
import org.flowable.spring.ProcessEngineFactoryBean;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author lee
 */
@Configuration
@Slf4j
public class FlowableConfiguration {

    /**
     * 初始化flowable的配置
     * @return
     */
    @Bean
    public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
        log.info("bne:flowable:SpringProcessEngineConfiguration config starting...");
        SpringProcessEngineConfiguration springProcessEngineConfiguration = new SpringProcessEngineConfiguration();

        Resource[] resources = new Resource[] {
            new ClassPathResource("classpath:processes/*.bpmn20.xml"),
        };
        springProcessEngineConfiguration.setDeploymentResources(resources);
        return springProcessEngineConfiguration;
    }

    /**
     * 初始化流程引擎
     * @return
     */
    public ProcessEngineFactoryBean getProcessEngine(){
        return new ProcessEngineFactoryBean();
    }

}
