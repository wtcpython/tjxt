package com.tianji.api.dto;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Collections;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * id和nun模型，一个id对应的数量可以用与查询id和num的关系
 * @author wusongsong
 * @since 2022/8/3 9:27
 * @version 1.0.0
 **/
@Data
public class IdAndNumDTO {
    private Long id;
    private Integer num;

    public static Map<Long, Integer> toMap(List<IdAndNumDTO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyMap();
        }
        return list.stream().collect(Collectors.toMap(IdAndNumDTO::getId, IdAndNumDTO::getNum));
    }
}
