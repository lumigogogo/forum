package dao;

import entity.Article;

import java.util.List;

public interface ArticleDao {

    /**
     * 新建文章 role-all
     * @param ownerId
     * @param article
     * @return
     */
    boolean createArticle(Long ownerId, Article article);

    /**
     * 获取文章详情 role-all
     * @param articleId
     * @return
     */
    Article getArticleDetail(Long articleId);

    /**
     * 修改文章内容 role-owner & superAdmin
     * @param articleId
     * @param article
     * @return
     */
    boolean updateArticle(Long articleId, Article article);

    /**
     * 修改文章状态 superAdmin
     * @param articleId
     * @param state
     * @return
     */
    boolean updateArticleState(Long articleId, Short state);

    /**
     * 删除文章 role-owner & superAdmin
     * @param articleId
     * @return
     */
    boolean deleteArticle(Long articleId);

    /**
     * 删除某个用户的所有文章 role-superAdmin
     * @param userId
     * @return
     */
    int deleteArticlesByUser(Long userId);

    /**
     * 批量删除文章 role-owner & superAdmin
     * @param articleIds
     * @return
     */
    int deleteArticlesByList(List<Long> articleIds);

    /**
     * 查询用户发表的所有文章 role-all
     * @param userId
     * @return
     */
    List<Article> getArticlesByUser(Long userId, Integer offset, Integer limit);
}
