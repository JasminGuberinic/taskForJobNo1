package com.boot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	String id; //Guid
	@Column(name="STREAMING_DIRECTION")
	StreamingDirection streamingDirection;
	@Column(name="TECHNOLOGY_TYPE")
	String technologyType;
	@Column(name="TECHNOLOGY_CATEGORY")
	String technologyCategory;
	
	public Product() {}
	public Product(String id, StreamingDirection streamingDirection, 
			String technologyType, String technologyCategory) {
		this.id= id;
		this.streamingDirection = streamingDirection;
		this.technologyType = technologyType;
		this.technologyCategory = technologyCategory;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StreamingDirection getStreamingDirection() {
		return streamingDirection;
	}
	public void setStreamingDirection(StreamingDirection streamingDirection) {
		this.streamingDirection = streamingDirection;
	}
	public String getTechnologyType() {
		return technologyType;
	}
	public void setTechnologyType(String technologyType) {
		this.technologyType = technologyType;
	}
	public String getTechnologyCategory() {
		return technologyCategory;
	}
	public void setTechnologyCategory(String technologyCategory) {
		this.technologyCategory = technologyCategory;
	}
}
