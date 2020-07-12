package com.authority.manager.base.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形数据的基础类
 * @author : yls
 * @date : 2020/07/12 14:25
 */
public class TreeData {

	/**
	 * 节点id
	 */
	private String id;

	/**
	 * 节点显示名称
	 */
	private String text;

	/**
	 * 节点图标代码
	 */
	private String iconCls;

	/**
	 * 是否展开节点
	 */
	private boolean expanded = true;

	/**
	 * 是否为叶子节点
	 */
	private boolean leaf = false;

	/**
	 * 子节点
	 */
	private List<TreeData> children = new ArrayList<TreeData>();

	/**
	 * 数据对象
	 */
	private Object object; //

	/**
	 * 数据list
	 */
	private List<?> arrayList;
	
	public TreeData() {
		
	}
	
	public TreeData(String id, String text, String iconCls, boolean expanded,
			boolean leaf) {
		super();
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.expanded = expanded;
		this.leaf = leaf;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public List<TreeData> getChildren() {
		return children;
	}

	public void setChildren(List<TreeData> children) {
		this.children = children;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public List<?> getArrayList() {
		return arrayList;
	}

	public void setArrayList(List<?> arrayList) {
		this.arrayList = arrayList;
	}

	@Override
	public String toString() {
		return "TreeData{" +
				"id='" + id + '\'' +
				", text='" + text + '\'' +
				", iconCls='" + iconCls + '\'' +
				", expanded=" + expanded +
				", leaf=" + leaf +
				", children=" + children +
				", object=" + object +
				", arrayList=" + arrayList +
				'}';
	}
}
