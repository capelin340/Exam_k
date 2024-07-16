package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateAction extends Action {

    // オーバーライド
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 処理内容（シーケンス図から）
        // 1: 学生の詳細データを取得
        String no = req.getParameter("no"); // 変更対象の学生番号の取得
        StudentDao sDao = new StudentDao();
        Student stu = sDao.get(no); // 変更対象の学生詳細データを取得

        // 2: クラスの一覧を取得
        HttpSession session = req.getSession(); // セッション開始
        Teacher teacher = (Teacher) session.getAttribute("user");
        School school = teacher.getSchool(); // ログインユーザの所属校データを取得(cd, name)
        ClassNumDao cNumDao = new ClassNumDao(); // クラス番号Daoを取得
        List<String> class_list = cNumDao.filter(school); // クラスの一覧を取得

        // 3: 画面表示
        req.setAttribute("stu_date", stu); // 学生の詳細データ
        req.setAttribute("class_list", class_list); // クラスの一覧

        // JSPへフォワード
        req.getRequestDispatcher("student_update.jsp").forward(req, res);
    }
}
