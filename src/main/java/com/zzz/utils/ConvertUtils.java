package com.zzz.utils;

import com.zzz.support.PageResult;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换工具类
 */
@SuppressWarnings("unchecked")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConvertUtils {

    /**
     * list po转vo
     * @param pos
     * @param voClass
     * @param <V>
     * @param <P>
     * @return
     */
    public static <V, P> List<V> convertPos2Vos(List<P> pos, Class<V> voClass) {
        return pos.stream()
                .map(po -> {
                    try {
                        V vo = voClass.newInstance();
                        BeanUtils.copyProperties(po, vo);
                        return vo;
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new IllegalArgumentException(String.format("pos转vos错误：%s", e.getMessage()));
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * 将springdatajpa返回的page转换为自己封装的pageResult
     * @param page
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> PageResult<T> convertPage(Page<R> page, Class<T> targetClass) {
        PageResult<T> pageResult = PageResult.<T>builder()
                .curPage(page.getNumber() + 1)
                .size(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();
        List<R> sourceList = page.getContent();

        if (CollectionUtils.isEmpty(sourceList)) {
            pageResult.setContent(Collections.emptyList());
            return pageResult;
        }

        List<T> targetList = sourceList.stream()
                .map(r -> {
                    try {
                        T t = targetClass.newInstance();
                        BeanUtils.copyProperties(r, t);
                        return t;
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new IllegalArgumentException(String.format("泛型转换出现异常！异常信息：%s", e.getMessage()));
                    }
                })
                .collect(Collectors.toList());

        pageResult.setContent(targetList);

        return pageResult;
    }

    /**
     * list转数组
     * @param sourceList
     * @param clazz
     * @param <A>
     * @return
     */
    public static <A> A[] convertList2Array(List<A> sourceList, Class<A> clazz) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return null;
        }

        A[] array = (A[]) Array.newInstance(clazz, sourceList.size());

        return sourceList.toArray(array);

    }

}
