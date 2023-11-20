package com.example.demo.interceptor;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
})
@Component
public class BeforeUpdateInterceptor implements Interceptor {


    static JsonMapper jsonMapper;
    static Logger logger;

    static {
        jsonMapper = new JsonMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        logger = LoggerFactory.getLogger(BeforeUpdateInterceptor.class);
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("=======================");
        System.out.println(invocation.getArgs());
        System.out.println(invocation.getTarget());
        System.out.println(invocation.getMethod());
        System.out.println(logger);
        System.out.println("=======================");
        logger.debug("开始更新数据，同时赋值更新人和更新时间");
        Object data = invocation.getArgs()[1];
        Class cls = data.getClass();
        String json = jsonMapper.writeValueAsString(data);
        Map datamap = jsonMapper.readValue(json, Map.class);
        if (datamap.containsKey("updateTime"))
            datamap.put("updateTime", LocalDateTime.now());
        if (datamap.containsKey("updateBy"))
            datamap.put("updateBy", "autoUser");
        Object newdt = jsonMapper.readValue(jsonMapper.writeValueAsString(datamap), cls);
        invocation = new Invocation(invocation.getTarget(), invocation.getMethod(), new Object[]{invocation.getArgs()[0], newdt});

        logger.debug("赋值更新人和更新时间完成,result:" + cls.toString());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
