package com.cheng.weixin.rpc.wxtools.response.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 群组
 * @author Cheng
 *
 */
@JsonInclude(Include.NON_NULL)
public class WxGroup {
	private Integer id;
	private String name;
	private Integer count;
	
	public WxGroup() {}
	public WxGroup(Integer id) {
		this.id = id;
	}
	
	public WxGroup(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", count=" + count + "]";
	}
	
}
