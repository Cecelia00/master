package com.open.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_picture")
public class Picture implements Serializable{

	private static final long serialVersionUID =  7295085861626878138L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "home_page")
	private String homePage;

	@Column(name = "home_page2")
	private String homePage2;

	@Column(name = "home_page3")
	private String homePage3;

	@Column(name = "activity")
	private String activity;

	@Column(name = "news")
	private String news;

	@Column(name = "worlds")
	private String worlds;

	@Column(name = "teach")
	private String teach;

	@Column(name = "join_us")
	private String joinUs;


	public Long getId() {
    return id;
  }

	public void setId(Long id) {
    this.id = id;
  }


	public String getHomePage() {
    return homePage;
  }

	public void setHomePage(String homePage) {
    this.homePage = homePage;
  }


	public String getHomePage2() {
    return homePage2;
  }

	public void setHomePage2(String homePage2) {
    this.homePage2 = homePage2;
  }


	public String getHomePage3() {
    return homePage3;
  }

	public void setHomePage3(String homePage3) {
    this.homePage3 = homePage3;
  }


	public String getActivity() {
    return activity;
  }

	public void setActivity(String activity) {
    this.activity = activity;
  }


	public String getNews() {
    return news;
  }

	public void setNews(String news) {
    this.news = news;
  }


	public String getWorlds() {
    return worlds;
  }

	public void setWorlds(String worlds) {
    this.worlds = worlds;
  }


	public String getTeach() {
    return teach;
  }

	public void setTeach(String teach) {
    this.teach = teach;
  }


	public String getJoinUs() {
    return joinUs;
  }

	public void setJoinUs(String joinUs) {
    this.joinUs = joinUs;
  }

}
