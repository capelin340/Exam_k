package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {
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
        String error = null;

        // 科目コードが3桁であるかチェック
        if (cd == null || cd.length() != 3) {
            error = "科目コードは3桁で入力してください。";
        } else {
            try {
                // 既存の科目をチェック
                Subject existingSubject = dao.get(cd, teacher.getSchool());
                if (existingSubject != null) {
                    // 科目コードが重複している場合
                    error = "指定された科目コードは既に使用されています。";
                } else if (dao.save(subject)) {
                    request.setAttribute("message", "科目を登録しました。");
                    request.getRequestDispatcher("subject_create_done.jsp").forward(request, response);
                    return;
                } else {
                    error = "科目の登録に失敗しました。";
                }
            } catch (Exception e) {
                error = "エラーが発生しました: " + e.getMessage();
            }
        }

        // エラーがある場合、入力ページに戻る
        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("subject", subject);
            request.getRequestDispatcher("subject_create.jsp").forward(request, response);
        }
    }
}