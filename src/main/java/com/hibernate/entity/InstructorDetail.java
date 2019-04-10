package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@OneToOne(mappedBy="insDetail", cascade=CascadeType.ALL)
	private Instructor instructor;
	

	public InstructorDetail(String hobby, String youtubeChannel) {
		this.hobby = hobby;
		this.youtubeChannel = youtubeChannel;
	}
	
	public InstructorDetail() {}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public int getId() {
		return id;
	}
	
	
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", hobby=" + hobby + ", youtubeChannel=" + youtubeChannel + "]";
	}
	
	

}
