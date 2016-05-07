package com.briup.cms.dao;
/**
 * 关于栏目信息与数据库交互的类
 * 增删改查方法，不涉及业务逻辑处理
 **/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.briup.cms.bean.Category;
import com.briup.cms.common.ConnectionFactory;

public class CategoryDao {
	/**
	 *将category 对象中的栏目信息保存到数据库栏目表中
	 * @param category
	 **/
	public void save(Category category){
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
			
			try{
				//获取连接
				conn = ConnectionFactory.getConn();
				String sql ="insert into t_category(name,code) values(?,?)";
				//预处理sql
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category.getName());
				pstmt.setString(2, category.getCode());
				//执行sql
				pstmt.executeUpdate();
			}finally{
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有的栏目信息
	 * @return包涵栏目信息的集合
	 * */
	public List<Category>    findAll(){
		return null;
	}
}
