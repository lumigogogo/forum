package com.egg.dao;

import com.egg.entity.Task;

import java.util.List;

public interface TaskDao {

    /**
     * 发表评论 role-all
     *
     * @param task
     * @return
     */
    boolean createComment(Task task);

    /**
     * 删除一条评论 role-superAdmin
     *
     * @param commentId
     * @return
     */
    boolean deleteComment(Long commentId);

    /**
     * 修改评论 role-owner & superAdmin
     *
     * @param commentId
     * @param task
     * @return
     */
    boolean updateComment(Long commentId, Task task);

    /**
     * 修改评论状态 role-superAdmin
     *
     * @param commentId
     * @param state
     * @return
     */
    boolean updateCommentState(Long commentId, Short state);

    /**
     * 删除某篇文章某位用户的所有评论 role-superAdmin
     *
     * @param userId
     * @param articleId
     * @return
     */
    int deleteCommentsByUserForArticle(Long userId, Long articleId);

    /**
     * 批量删除评论 role-superAdmin
     *
     * @param commentIds
     * @return
     */
    int deleteCommentsByList(List<Integer> commentIds);

    /**
     * 查询某位用户的所有评论 role-owner & superAdmin
     *
     * @param userId
     * @param offset
     * @param limit
     * @return
     */
    List<Task> getCommentsByUser(Long userId, Integer offset, Integer limit);

    /**
     * 查询用户对某篇文章的所有评论 all
     *
     * @param userId
     * @param articleId
     * @return
     */
    List<Task> getUserCommentsByArticle(Long userId, Long articleId, Integer offset, Integer limit);
}
