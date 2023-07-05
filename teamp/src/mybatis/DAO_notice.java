package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO_notice {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		ss.commit();
		return ss;
	}

		public static List<VO_notice> getAll(){
			List<VO_notice> a_list = null;
			
			a_list = getSession().selectList("usernotice_all");
			return a_list;
		}
}
