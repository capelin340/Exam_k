package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.TestListStudent;
import dao.StudentDao;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

	//シ：ログインユーザー情報の取得
//		HttpSession session = req.getSession();//セッション
//		Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー

	//シ：科目データ(一覧)の取得
//		SubjectDao sDao = new SubjectDao();// 科目Daoを初期化
//		List<Subject> subjects = sDao.filter(teacher.getSchool());//科目の一覧を取得

	//リクエストパラメータ―の取得(学生から検索の場合)
		String studentNo = req.getParameter("f4");//学生番号の取得
		StudentDao stuDao = new StudentDao();
		Student student =  stuDao.get(studentNo);//学生情報の取得

	// 成績を取得
		TestListStudentDao tlsDao = new TestListStudentDao();
		List<TestListStudent> students = tlsDao.filter(student);
//					// リクエストに回数をセット設定
//					req.setAttribute("num", num);

		// リクエストに成績を設定
		req.setAttribute("student", student);
		req.setAttribute("tests", students);

	//JSPへフォワード
		req.getRequestDispatcher("test_list_student.jsp").forward(req,res);
		}
	}