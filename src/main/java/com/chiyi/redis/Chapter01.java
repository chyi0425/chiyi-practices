package com.chiyi.redis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 溢
 */
public class Chapter01 {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCIRE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    public void run(){
        Jedis conn = new Jedis("192.168.123.2");
        conn.select(15);

        String articleId = postArticle(conn,"username", "A title", "http://www.google.com");
        System.out.println("We posted a new article with id:"+articleId);
        System.out.println("Its HASH look like:");
        Map<String,String> articleData = conn.hgetAll("article:"+articleId);
        for(Map.Entry<String,String> entry:articleData.entrySet()){
            System.out.println(" "+entry.getKey()+": "+entry.getValue());
        }
        System.out.println();

        articleVote(conn,"other_user","article:"+articleId);
    }

    private void articleVote(Jedis conn, String user, String article) {

    }

    private String postArticle(Jedis conn, String user, String title, String link) {
        String articleId = String.valueOf(conn.incr("article:"));
        String voted = "voted:" + articleId;
        conn.sadd(voted,user);
        conn.expire(voted,ONE_WEEK_IN_SECONDS);

        long now = System.currentTimeMillis()/1000;
        String article = "article:"+articleId;
        Map<String, String> articleData = new HashMap<String, String>();
        articleData.put("title",title);
        articleData.put("link",link);
        articleData.put("user",user);
        articleData.put("now",String.valueOf(now));
        articleData.put("votes","1");
        conn.hmset(article,articleData);

        return articleId;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.1.51.19",6379);
        jedis.zincrby("201903_star_anchor_month#2#62",3,"20169853#77591992");
        jedis.zincrby("201903_star_anchor_month#2#62",8,"20169853#77591992");
        jedis.zrangeWithScores("201903_star_anchor_month#2#62",0,-1);
    }
    /**
     * 197. Rising Temperature
     * select b.Id from Weather a right join Weather b on b.RecordDate= DATE_ADD(a.RecordDate, INTERVAL 1 DAY)
     where (b.Temperature-a.Temperature)>0
     */
}
