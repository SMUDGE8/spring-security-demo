package com.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author lei
 * @since 2018/1/30
 */
@Configurable
@ComponentScan(basePackages = "com",
        excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value=Controller.class)}
)
public class RootConfig {
}
