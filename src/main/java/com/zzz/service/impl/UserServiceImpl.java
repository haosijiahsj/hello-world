package com.zzz.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.zzz.dao.UserRepository;
import com.zzz.model.po.UserPo;
import com.zzz.model.vo.UserVo;
import com.zzz.service.UserService;
import com.zzz.support.PageResult;
import com.zzz.utils.ConvertUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

/**
 * @author 胡胜钧
 * @date 2/25 0025.
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserVo userVo) {
        Preconditions.checkArgument(userVo != null, "入参userVo不能为空！");

        UserPo userPo = new UserPo();

        BeanUtils.copyProperties(userVo, userPo);

        userRepository.save(userPo);
    }

    @Override
    public UserVo findByUsername(String username) {
        Preconditions.checkArgument(StringUtils.isNotBlank(username), "入参username不能为空！");

        UserPo userPo = userRepository.findByUsername(username);

        if (userPo == null) {
            log.info("通过username: [{}]没有查询到用户信息！", username);
            return null;
        }

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userPo, userVo);

        return userVo;
    }

    @Override
    public void updatePassword(UserVo userVo) {
        Preconditions.checkArgument(userVo != null, "入参userVo不能为空！");

        userRepository.updatePassword(userVo.getUsername(), userVo.getPassword());
    }

    @Override
    public List<UserVo> findAll() {
        List<UserPo> userPos = userRepository.findAll();

        return CollectionUtils.isEmpty(userPos) ? Collections.emptyList()
                : ConvertUtils.convertPos2Vos(userPos, UserVo.class);
    }

    @Override
    public PageResult<UserVo> findAll(UserVo userVo, Pageable pageable) {
        Preconditions.checkArgument(pageable != null, "入参pageable不能为空！");

        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(userVo, userPo);

        Page<UserPo> userPoPage = userRepository.findAll(this.buildSpecification(userPo), pageable);

        return ConvertUtils.convertPage(userPoPage, UserVo.class);
    }

    @Override
    public PageResult<UserVo> findUser(String username, Pageable pageable) {
        Preconditions.checkArgument(pageable != null, "入参pageable不能为空！");

        if (StringUtils.isNotEmpty(username)) {
            UserPo userPo = userRepository.findByUsername(username);

            PageResult<UserVo> pageResult = new PageResult<>();
            pageResult.setCurPage(pageable.getPageNumber() + 1);
            pageResult.setSize(pageable.getPageSize());
            pageResult.setTotalElements(1L);
            pageResult.setTotalPages(1);

            if (userPo == null) {
                pageResult.setTotalElements(0L);
                pageResult.setTotalPages(0);
                pageResult.setContent(Collections.emptyList());
            } else {
                UserVo userVo = new UserVo();
                BeanUtils.copyProperties(userPo, userVo);
                pageResult.setContent(Lists.newArrayList(userVo));
            }

            return pageResult;
        }

        return ConvertUtils.convertPage(userRepository.findAll(pageable), UserVo.class);
    }

    @Override
    public void delete(Integer id) {
        Preconditions.checkArgument(id != null, "入参id不能为空！");

        userRepository.deleteById(id);
    }

    /**
     * 创建动态查询条件
     * @param userPo
     * @return
     */
    private Specification<UserPo> buildSpecification(UserPo userPo) {
        return (Specification<UserPo>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = Lists.newArrayList();

            if (StringUtils.isNotEmpty(userPo.getUsername())) {
                predicates.add(criteriaBuilder.like(root.get("username"), "%" + userPo.getUsername() + "%"));
            }
            if (StringUtils.isNotEmpty(userPo.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + userPo.getName() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

}
