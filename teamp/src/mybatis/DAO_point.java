package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO_point {
private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		ss.commit();
		return ss;
	}

	public static int getPInsert(VO_point vo) {
		int result = getSession().insert("p_Ins", vo);
		ss.commit();
		return result;
	}
	
	/*
	 * public static VO_point p_One(String p_attribute) { VO_point vo =
	 * getSession().selectOne("p_One", p_attribute); return vo; }
	 */


	public static List<VO_point> p_All(String p_attribute) {
		List<VO_point> p_list = null;

		p_list = getSession().selectList("p_All", p_attribute);
		return p_list;
	}
}
