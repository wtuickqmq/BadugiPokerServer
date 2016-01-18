package com.badugi.game.logic.model.vo.fb;

public class Wordage {
	private String content;//文字内容
	private Integer left;//距离图片左边距离
	private Integer top;//距离图片顶部距离
	private Integer colorType;//颜色类型 1为白色 2为黑色 3为红色
	private String fontType;//文字字体
	private int fontSize;//文字大小
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getColorType() {
		return colorType;
	}
	public void setColorType(Integer colorType) {
		this.colorType = colorType;
	}
	public String getFontType() {
		return fontType;
	}
	public void setFontType(String fontType) {
		this.fontType = fontType;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public Wordage(String content, Integer left, Integer top,
			Integer colorType, String fontType, int fontSize) {
		super();
		this.content = content;
		this.left = left;
		this.top = top;
		this.colorType = colorType;
		this.fontType = fontType;
		this.fontSize = fontSize;
	}
	public Wordage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
