package tool;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = { "*.action" })
public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // パスを取得
            String path = req.getServletPath().substring(1);
            // ファイル名を取得しクラス名に変換
            String name = path.replace(".a", "A").replace('/', '.');

            System.out.println("★ servlet path -> " + req.getServletPath());
            System.out.println("★ class name -> " + name);

            // アクションクラスのインスタンスを返却
            Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();

            // 遷移先URLを取得
            action.execute(req, res);
        } catch (Exception e) {
            e.printStackTrace();
            // エラーページへリダイレクト
            req.getRequestDispatcher("/error.jsp").forward(req, res);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
