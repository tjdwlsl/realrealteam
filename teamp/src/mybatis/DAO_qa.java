package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO_qa {
	private static SqlSession ss;

	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		ss.commit();
		return ss;
	}

	public static int getInsert(VO_qa vo) {
		int result = getSession().insert("userqa", vo);
		ss.commit();
		return result;
	}

	public static int getDelete(String vo) {
		int result = getSession().delete("qaDel", vo);
		ss.commit();
		return result;
	}

	public static int getUpdate(VO_qa vo) {
		int result = getSession().update("qaUp", vo);
		ss.commit();
		return result;
	}

	public static List<VO_qa> getSelectAll() {
		List<VO_qa> list = null;

		list = getSession().selectList("userqa_all");
		return list;
	}
}
