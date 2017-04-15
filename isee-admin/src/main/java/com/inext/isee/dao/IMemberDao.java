package com.inext.isee.dao;

import com.inext.isee.entity.product.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * IMemberDao
 *
 * @author zhiliao
 * @since 2017-04-12
 */
@Repository
public interface IMemberDao {
    List<Member> getMemberList();
}
