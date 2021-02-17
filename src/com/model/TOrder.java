package com.model;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class TOrder implements java.io.Serializable {

	// Fields

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
	private Integer songhuoyuanId;
	
	private String songhuoyuanHuidan;
	
	
	private TSonghuoyuan songhuoyuan;

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

	public TSonghuoyuan getSonghuoyuan() {
		return songhuoyuan;
	}

	public void setSonghuoyuan(TSonghuoyuan songhuoyuan) {
		this.songhuoyuan = songhuoyuan;
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

	public Integer getSonghuoyuanId() {
		return songhuoyuanId;
	}

	public void setSonghuoyuanId(Integer songhuoyuanId) {
		this.songhuoyuanId = songhuoyuanId;
	}

	public String getSonghuoyuanHuidan() {
		return songhuoyuanHuidan;
	}

	public void setSonghuoyuanHuidan(String songhuoyuanHuidan) {
		this.songhuoyuanHuidan = songhuoyuanHuidan;
	}

	
	
}