package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String cd = request.getParameter("cd");

        SubjectDao dao = new SubjectDao();
        String message;

        try {
            Subject subject = dao.get(cd, teacher.getSchool());
            if (subject != null) {
                if (dao.delete(subject)) {
                    message = "科目を削除しました。";
                } else {
                    message = "科目の削除に失敗しました。";
                }
            } else {
                message = "指定された科目が見つかりません。";
            }
        } catch (Exception e) {
            message = "エラーが発生しました: " + e.getMessage();
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("subject_delete_done.jsp").forward(request, response);
    }
}