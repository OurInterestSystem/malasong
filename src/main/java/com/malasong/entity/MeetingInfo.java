package com.malasong.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meetinginfo")
public class MeetingInfo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String desc;
	
	private Timestamp starttime;
	
	private Timestamp endtime;
	
	private int limitation;
	
	private int currentCount;
	
	private String namelist;
	
	private String tag;
	
	private int status;
	
	private String waitinglist;
	
	private String location;
	
	private String attendedlist;
	
	public MeetingInfo(){
		this.currentCount = 0;
		this.status = 1;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDescri(String desc) {
		this.desc = desc;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public int getLimitation() {
		return limitation;
	}

	public void setLimitation(int limitation) {
		this.limitation = limitation;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public String getNamelist() {
		return namelist;
	}

	public void setNamelist(String namelist) {
		this.namelist = namelist;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getWaitinglist() {
		return waitinglist;
	}

	public void setWaitinglist(String waitinglist) {
		this.waitinglist = waitinglist;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAttendedlist() {
		return attendedlist;
	}

	public void setAttendedlist(String attendedlist) {
		this.attendedlist = attendedlist;
	}
		
}
