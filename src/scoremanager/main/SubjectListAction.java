package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        SubjectDao sDao = new SubjectDao();
        List<Subject> subjects = null;

        try {
            subjects = sDao.filter(teacher.getSchool());
            request.setAttribute("subjects", subjects);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "データベースエラーが発生しました。");
        }

        request.getRequestDispatcher("subject_list.jsp").forward(request, response);
    }
}