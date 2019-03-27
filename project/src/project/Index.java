package project;
import java.sql.Connection;
import project.MemberVO;
import project.MemberDAO;


public class Index {
		Connection con=null;
		
		MemberVO vo=new MemberVO();
		MemberDAO dao=new MemberDAO(con);
		
		
}
