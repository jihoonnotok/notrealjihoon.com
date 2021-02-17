package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TOrderDAO;
import com.dao.TSonghuoyuanDAO;
import com.model.TOrder;
import com.model.TSonghuoyuan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class orderAction extends ActionSupport
{
	private Integer id;
	private String danhao;
	private String huoleixing;
	private String huomingcheng;
	
	private String huozhong;
	private String jixingming;
	private String jidianhua;
	private String jidizhi;
	
	private String shouxingming;
	private String shoudianhua;
	private String shoudizhi;
	private int songhuoyuanId;
	
	private String songhuoyuanHuidan;
	
	private TOrderDAO orderDAO;
	private TSonghuoyuanDAO songhuoyuanDAO;
	
	public String orderAdd()
	{
		TOrder order=new TOrder();
		
		//order.setId(id);
		order.setDanhao(danhao);
		order.setHuoleixing(huoleixing);
		order.setHuomingcheng(huomingcheng);
		
		order.setHuozhong(huozhong);
		order.setJixingming(jixingming);
		order.setJidianhua(jidianhua);
		order.setJidizhi(jidizhi);
		
		order.setShouxingming(shouxingming);
		order.setShoudianhua(shoudianhua);
		order.setShoudizhi(shoudizhi);
		order.setSonghuoyuanId(0);//如果送货员id是0，表示没有指派送货员。所有倒序
		
		order.setSonghuoyuanHuidan("");
		
		
		orderDAO.save(order);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息添加成功");
		return "msg";
	}
	
	
	public String orderMana()
	{
		String sql="from TOrder";
		List orderList =orderDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<orderList.size();i++)
		{
			TOrder order=(TOrder)orderList.get(i);
			order.setSonghuoyuan(songhuoyuanDAO.findById(order.getSonghuoyuanId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	public String orderDel()
	{   
		TOrder order=orderDAO.findById(id);
		orderDAO.delete(order);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息删除成功");
		return "msg";
	}
	
	
	public String orderDetailHou()
	{   
		TOrder order=orderDAO.findById(id);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("order", order);
		return ActionSupport.SUCCESS;
	}
	
	
	
	
	public String songhuoyuanFenpai()
	{   
		TOrder order=orderDAO.findById(id);
		
		order.setSonghuoyuanId(songhuoyuanId);
		
		orderDAO.attachDirty(order);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "分配完毕");
		return "msg";
	}
	
	
	
	
	public String orderMana_songhuoyuan()
	{
		Map session=ActionContext.getContext().getSession();
		TSonghuoyuan songhuoyuan=(TSonghuoyuan)session.get("songhuoyuan");
		
		String sql="from TOrder where songhuoyuanId="+songhuoyuan.getId();
		List orderList =orderDAO.getHibernateTemplate().find(sql);
		for(int i=0;i<orderList.size();i++)
		{
			TOrder order=(TOrder)orderList.get(i);
			order.setSonghuoyuan(songhuoyuanDAO.findById(order.getSonghuoyuanId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String order_huidan_add()
	{   
		TOrder order=orderDAO.findById(id);
		
		order.setSonghuoyuanHuidan(songhuoyuanHuidan);
		
		orderDAO.attachDirty(order);
		
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("msg", "信息更新完毕");
		return "msg";
	}
	
	
	
	public String orderRes()
	{
		String sql="from TOrder where danhao=?";
		Object[] c={danhao.trim()};
		List orderList =orderDAO.getHibernateTemplate().find(sql,c);
		for(int i=0;i<orderList.size();i++)
		{
			TOrder order=(TOrder)orderList.get(i);
			order.setSonghuoyuan(songhuoyuanDAO.findById(order.getSonghuoyuanId()));
		}
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("orderList", orderList);
		return ActionSupport.SUCCESS;
	}
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDanhao() {
		return danhao;
	}


	public void setDanhao(String danhao) {
		this.danhao = danhao;
	}


	public String getHuoleixing() {
		return huoleixing;
	}


	public void setHuoleixing(String huoleixing) {
		this.huoleixing = huoleixing;
	}


	public String getHuomingcheng() {
		return huomingcheng;
	}


	public void setHuomingcheng(String huomingcheng) {
		this.huomingcheng = huomingcheng;
	}


	public String getHuozhong() {
		return huozhong;
	}


	public void setHuozhong(String huozhong) {
		this.huozhong = huozhong;
	}


	public String getJixingming() {
		return jixingming;
	}


	public void setJixingming(String jixingming) {
		this.jixingming = jixingming;
	}


	public String getJidianhua() {
		return jidianhua;
	}


	public void setJidianhua(String jidianhua) {
		this.jidianhua = jidianhua;
	}


	public String getJidizhi() {
		return jidizhi;
	}


	public void setJidizhi(String jidizhi) {
		this.jidizhi = jidizhi;
	}


	public String getShouxingming() {
		return shouxingming;
	}


	public void setShouxingming(String shouxingming) {
		this.shouxingming = shouxingming;
	}


	public String getShoudianhua() {
		return shoudianhua;
	}


	public void setShoudianhua(String shoudianhua) {
		this.shoudianhua = shoudianhua;
	}


	public String getShoudizhi() {
		return shoudizhi;
	}


	public void setShoudizhi(String shoudizhi) {
		this.shoudizhi = shoudizhi;
	}


	
	public int getSonghuoyuanId() {
		return songhuoyuanId;
	}


	public void setSonghuoyuanId(int songhuoyuanId) {
		this.songhuoyuanId = songhuoyuanId;
	}


	

	public TSonghuoyuanDAO getSonghuoyuanDAO() {
		return songhuoyuanDAO;
	}


	public void setSonghuoyuanDAO(TSonghuoyuanDAO songhuoyuanDAO) {
		this.songhuoyuanDAO = songhuoyuanDAO;
	}


	public String getSonghuoyuanHuidan() {
		return songhuoyuanHuidan;
	}


	public void setSonghuoyuanHuidan(String songhuoyuanHuidan) {
		this.songhuoyuanHuidan = songhuoyuanHuidan;
	}


	public TOrderDAO getOrderDAO() {
		return orderDAO;
	}


	public void setOrderDAO(TOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	
	
	
}
