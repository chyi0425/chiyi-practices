package com.chiyi.elasticsearch;

import java.util.Date;

/**
 * @author chiyi
 */
public class DocVo {
    private String doc_resource_id;
    private String doc_cate_id;
    private String doc_name;
    private String doc_keyword;
    private String doc_description;
    private String content;
    private String state;
    private String edit_type;
    private String author_name;
    private Date create_time;
    private Date update_time;
    private String updater_name;

    public DocVo(String doc_resource_id, String doc_cate_id, String doc_name, String doc_keyword,
            String doc_description, String content, String state, String edit_type, String author_name,
            Date create_time, Date update_time, String updater_name) {
        this.doc_resource_id = doc_resource_id;
        this.doc_cate_id = doc_cate_id;
        this.doc_name = doc_name;
        this.doc_keyword = doc_keyword;
        this.doc_description = doc_description;
        this.content = content;
        this.state = state;
        this.edit_type = edit_type;
        this.author_name = author_name;
        this.create_time = create_time;
        this.update_time = update_time;
        this.updater_name = updater_name;
    }

    public String getDoc_resource_id() {
        return doc_resource_id;
    }

    public void setDoc_resource_id(String doc_resource_id) {
        this.doc_resource_id = doc_resource_id;
    }

    public String getDoc_cate_id() {
        return doc_cate_id;
    }

    public void setDoc_cate_id(String doc_cate_id) {
        this.doc_cate_id = doc_cate_id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_keyword() {
        return doc_keyword;
    }

    public void setDoc_keyword(String doc_keyword) {
        this.doc_keyword = doc_keyword;
    }

    public String getDoc_description() {
        return doc_description;
    }

    public void setDoc_description(String doc_description) {
        this.doc_description = doc_description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEdit_type() {
        return edit_type;
    }

    public void setEdit_type(String edit_type) {
        this.edit_type = edit_type;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUpdater_name() {
        return updater_name;
    }

    public void setUpdater_name(String updater_name) {
        this.updater_name = updater_name;
    }
}
