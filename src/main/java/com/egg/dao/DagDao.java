package com.egg.dao;

import com.egg.entity.Dag;

import java.util.List;

public interface DagDao {

    /**
     * 新建文章 role-all
     *
     * @param ownerId
     * @param dag
     * @return
     */
    boolean createArticle(Long ownerId, Dag dag);

    /**
     * 获取文章详情 role-all
     *
     * @param dagId
     * @return
     */
    Dag getArticleDetail(Long dagId);

    /**
     * 修改文章内容 role-owner & superAdmin
     *
     * @param dagId
     * @param dag
     * @return
     */
    boolean updateArticle(Long dagId, Dag dag);

    /**
     * 修改文章状态 superAdmin
     *
     * @param dagId
     * @param status
     * @return
     */
    boolean updateArticleState(Long dagId, Short status);

    /**
     * 删除文章 role-owner & superAdmin
     *
     * @param dagId
     * @return
     */
    boolean deleteArticle(Long dagId);

    /**
     * 删除某个用户的所有文章 role-superAdmin
     *
     * @param userId
     * @return
     */
    int deleteArticlesByUser(Long userId);

    /**
     * 批量删除文章 role-owner & superAdmin
     *
     * @param dagId
     * @return
     */
    int deleteArticlesByList(List<Long> dagId);

    /**
     * 查询用户发表的所有文章 role-all
     *
     * @param userId
     * @return
     */
    List<Dag> getArticlesByUser(Long userId, Integer offset, Integer limit);
}
