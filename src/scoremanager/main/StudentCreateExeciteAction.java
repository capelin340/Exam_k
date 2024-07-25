package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentCreateExeciteAction extends Action {

    // オーバーライド
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession(); // セッション開始

        // リクエストパラメータの取得
        int ent_year = Integer.parseInt(req.getParameter("ent_year")); // 入学年度
        String no = req.getParameter("no"); // 学生番号
        String name = req.getParameter("name"); // 氏名
        String class_num = req.getParameter("class_num"); // クラス番号

        // 入学年度の未入力チェック
        if (ent_year == 0) {
            req.setAttribute("no", no);
            req.setAttribute("name", name);
            req.setAttribute("class_num", class_num);
            // JSPへフォワード（入学年度未入力）
            req.getRequestDispatcher("StudentCreate.action").forward(req, res);
        }

        // Studentを登録するデータをセット
        Student stu = new Student();
        stu.setEntYear(ent_year);
        stu.setNo(no);
        stu.setName(name);
        stu.setClassNum(class_num);
        stu.setAttend(true);
        stu.setSchool(((Teacher) session.getAttribute("user")).getSchool());
        StudentDao sDao = new StudentDao();
        boolean flag = sDao.save(stu);

        // JSPへフォワード（登録完了）
        req.getRequestDispatcher("student_create_done.jsp").forward(req, res);
    }
}
