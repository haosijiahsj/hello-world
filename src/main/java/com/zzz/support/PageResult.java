package com.zzz.support;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果类
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -2101017243893880821L;

    private int curPage;
    private int size;
    private int totalPages;
    private long totalElements;
    private List<T> content;

}
