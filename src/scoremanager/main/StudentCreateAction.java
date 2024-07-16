package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class StudentCreateAction extends Action {

    // オーバーライド
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // 処理内容（セッションスコープ回から）
        // 1. セッションデータを取得
        HttpSession session = req.getSession(); // セッション開始
        Teacher teacher = (Teacher) session.getAttribute("user");

        // 2. セレクトボックス用のクラス番号一覧の取得
        ClassNumDao class_num = new ClassNumDao();
        List<String> class_list = class_num.filter(teacher.getSchool());

        // 3. student_create.jspの入学年度リストの取得
        LocalDate todaysDate = LocalDate.now(); // LocalDateインスタンスを取得
        int year = todaysDate.getYear(); // 現在の年を取得

        // 4. 初期化処理
        List<Integer> entYearSet = new ArrayList<>();
        // 現在から10年後までの年度リストに追加
        for (int i = year - 10; i <= year + 1; i++) {
            entYearSet.add(i);
        }

        // 5. リクエスト属性をセット
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("class_select", class_list);

        // 6. JSPへフォワード
        req.getRequestDispatcher("student_create.jsp").forward(req, res);
    }
}
