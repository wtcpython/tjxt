package com.tianji.learning.config;

import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.tianji.learning.utils.TableInfoContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class MybatisConfiguration {

    @Bean
    public DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor() {
        // Map<String, TableNameHandler> map = new HashMap<>(1);
        // map.put("points_board", (sql, tableName) -> TableInfoContext.getInfo());
        return new DynamicTableNameInnerInterceptor((sql, tableName) -> {
            if (Objects.equals(tableName, "points_board")) {
                return TableInfoContext.getInfo();
            }
            return tableName;
        });
    }
}
