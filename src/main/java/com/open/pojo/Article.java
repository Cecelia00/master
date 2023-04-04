package com.open.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_article")
public class Article implements Serializable{

	private static final long serialVersionUID =  2512817108151889375L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 创建时间
	 */
	@Column(name = "create_date")
	private Long createDate;

	/**
	 * 简介
	 */
	@Column(name = "summary")
	private String summary;

	/**
	 * 标题
	 */
	@Column(name = "title")
	private String title;

	/**
	 * 浏览数量
	 */
	@Column(name = "view_counts")
	private Long viewCounts;

	/**
	 * 是否置顶
	 */
	@Column(name = "weight")
	private Long weight;

	/**
	 * 内容id
	 */
	@Column(name = "body_id")
	private Long bodyId;

	/**
	 * 类别id
	 */
	@Column(name = "category_id")
	private Long categoryId;

	/**
	 * 文章缩略图
	 */
	@Column(name = "thumbnail")
	private String thumbnail;

	/**
	 * 文章分类
	 */
	@Column(name = "categories")
	private String categories;


	public Long getId() {
    return id;
  }

	public void setId(Long id) {
    this.id = id;
  }


	public Long getCreateDate() {
    return createDate;
  }

	public void setCreateDate(Long createDate) {
    this.createDate = createDate;
  }


	public String getSummary() {
    return summary;
  }

	public void setSummary(String summary) {
    this.summary = summary;
  }


	public String getTitle() {
    return title;
  }

	public void setTitle(String title) {
    this.title = title;
  }


	public Long getViewCounts() {
    return viewCounts;
  }

	public void setViewCounts(Long viewCounts) {
    this.viewCounts = viewCounts;
  }


	public Long getWeight() {
    return weight;
  }

	public void setWeight(Long weight) {
    this.weight = weight;
  }


	public Long getBodyId() {
    return bodyId;
  }

	public void setBodyId(Long bodyId) {
    this.bodyId = bodyId;
  }


	public Long getCategoryId() {
    return categoryId;
  }

	public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }


	public String getThumbnail() {
    return thumbnail;
  }

	public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }


	public String getCategories() {
    return categories;
  }

	public void setCategories(String categories) {
    this.categories = categories;
  }

}
