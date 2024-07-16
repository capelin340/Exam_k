package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String cd = request.getParameter("cd");
        String name = request.getParameter("name");

        Subject subject = new Subject();
        subject.setCd(cd);
        subject.setName(name);
        subject.setSchool(teacher.getSchool());

        SubjectDao dao = new SubjectDao();
        String message;

        try {
            if (dao.save(subject)) {
                message = "科目を更新しました。";
            } else {
                message = "科目の更新に失敗しました。";
            }
        } catch (Exception e) {
            message = "エラーが発生しました: " + e.getMessage();
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("subject_update_done.jsp").forward(request, response);
    }
}