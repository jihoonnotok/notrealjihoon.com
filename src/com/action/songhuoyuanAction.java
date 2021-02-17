package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TSonghuoyuanDAO;
import com.model.TSonghuoyuan;
import com.opensymphony.xwork2.ActionSupport;

public class songhuoyuanAction extends ActionSupport
{
	private Integer id;
	private String name;
	private String sex;
	private String age;
	
	private String tel;
	private String address;
	private String loginname;
	private String loginpw;
	
	private String del;
	
	private TSonghuoyuanDAO songhuoyuanDAO;
	
	public String songhuoyuanAdd()
	{
		TSonghuoyuan songhuoyuan=new TSonghuoyuan();
		
		//songhuoyuan.setId(id);
		songhuoyuan.setName(name);
		songhuoyuan.setSex(sex);
		songhuoyuan.setAge(age);
		
		songhuoyuan.setTel(tel);
		songhuoyuan.setAddress(address);
		songhuoyuan.setLoginname(loginname);
		songhuoyuan.setLoginpw(loginpw);
		
		songhuoyuan.setDel("no");
		songhuoyuanDAO.save(songhuoyuan);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	
	public String songhuoyuanMana()
	{
		String sql="from TSonghuoyuan where del='no'";
		List songhuoyuanList =songhuoyuanDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("songhuoyuanList", songhuoyuanList);
		return ActionSupport.SUCCESS;
	}
	
	public String songhuoyuanDel()
	{   
		String sql="update TSonghuoyuan set del='yes' where id="+id;
		songhuoyuanDAO.getHibernateTemplate().bulkUpdate(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	
	
	
	public String songhuoyuanSelect()
	{
		String sql="from TSonghuoyuan where del='no'";
		List songhuoyuanList =songhuoyuanDAO.getHibernateTemplate().find(sql);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("songhuoyuanList", songhuoyuanList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String songhuoyuanEditMe()
	{   
        TSonghuoyuan songhuoyuan=songhuoyuanDAO.findById(id);
		
		//songhuoyuan.setId(id);
		songhuoyuan.setName(name);
		songhuoyuan.setSex(sex);
		songhuoyuan.setAge(age);
		
		songhuoyuan.setTel(tel);
		songhuoyuan.setAddress(address);
		songhuoyuan.setLoginname(loginname);
		songhuoyuan.setLoginpw(loginpw);
		
		songhuoyuan.setDel("no");
		songhuoyuanDAO.attachDirty(songhuoyuan);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "修改成功，重新登陆后生效");
		return "msg";
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


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLoginname() {
		return loginname;
	}


	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}


	public String getLoginpw() {
		return loginpw;
	}


	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}


	public String getDel() {
		return del;
	}


	public void setDel(String del) {
		this.del = del;
	}


	public TSonghuoyuanDAO getSonghuoyuanDAO() {
		return songhuoyuanDAO;
	}


	public void setSonghuoyuanDAO(TSonghuoyuanDAO songhuoyuanDAO) {
		this.songhuoyuanDAO = songhuoyuanDAO;
	}

}
