package com.tianji.common.utils;

import com.tianji.common.validate.Checker;

import java.util.List;

/**
 * 集合工具类（仅保留需要抽象表达的集合操作）
 */
public class CollUtils {

    /**
     * 集合校验逻辑
     * @param data    要校验的集合
     * @param checker 校验器
     * @param <T>     集合元素类型
     */
    public static <T> void check(List<T> data, Checker<T> checker) {
        if (data == null) {
            return;
        }
        for (T t : data) {
            checker.check(t);
        }
    }

    /**
     * 集合校验逻辑
     * @param data 要校验的集合
     * @param <T>  集合元素类型
     */
    public static <T extends Checker<T>> void check(List<T> data) {
        if (data == null) {
            return;
        }
        for (T t : data) {
            t.check();
        }
    }
}