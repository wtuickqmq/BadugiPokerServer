package com.badugi.game.logic.dao.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.badugi.game.logic.dao.UserBasicDao;
import com.badugi.game.logic.model.entity.UserBasic;

@Repository("userBasicDao")
public class UserBasicDaoHibernate extends GenericDaoHibernate<UserBasic, Long> implements UserBasicDao {

	public UserBasicDaoHibernate() {
		super(UserBasic.class);
	}

	public UserBasic findUserBasic(Long fbId) {
   	UserBasic sic = new UserBasic();
   	String sql = "select userid,figureurl from user_basic where userid = "+fbId;
   	  try {
   		  List<Map<String,Object>> list = this.querySQLListWithMap(sql);
			if(list != null && list.size() > 0){
				
				Map<String,Object> map = list.get(0);
				if(!map.isEmpty()){
					String	figureurl = map.get("figureurl") != null ?  map.get("figureurl").toString() : "";
					Long userId = map.get("userid") != null ?Long.valueOf(map.get("userid").toString()): 1l ;
					sic.setFigureurl(figureurl);
					sic.setUserId(userId);
					return sic;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
   	  return null;
   }

}