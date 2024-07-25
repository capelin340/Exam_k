package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String cd = request.getParameter("cd");
        SubjectDao dao = new SubjectDao();

        try {
            Subject subject = dao.get(cd, teacher.getSchool());
            if (subject != null) {
                request.setAttribute("subject", subject);
                request.getRequestDispatcher("subject_delete.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "指定された科目が見つかりません。");
                request.getRequestDispatcher("SubjectList.action").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("message", "エラーが発生しました: " + e.getMessage());
            request.getRequestDispatcher("SubjectList.action").forward(request, response);
        }
    }
}