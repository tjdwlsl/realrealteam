package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO_ticketbuy {
private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		ss.commit();
		return ss;
	}

	public static int getTInsert(VO_ticketbuy vo) {
		int result = getSession().insert("t_Ins", vo);
		ss.commit();
		return result;
	}
	
	public static int getTRefund(String vo) {
		int result = getSession().delete("t_refund", vo);
		ss.commit();
		return result;
	}
	
	/*
	 * public static VO_point p_One(String p_attribute) { VO_point vo =
	 * getSession().selectOne("p_One", p_attribute); return vo; }
	 */


	public static List<VO_ticketbuy> T_All(String id) {
		List<VO_ticketbuy> t_list = null;

		t_list = getSession().selectList("t_All", id);
		return t_list;
	}
	
	public static VO_ticketbuy tOne(String id) {
		VO_ticketbuy vo = getSession().selectOne("tOne", id);
		return vo;
	}
}
