<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">科目削除確認</c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目削除確認</h2>
            <p>以下の科目を削除します。よろしいですか？</p>
            <table class="table">
                <tr>
                    <th>科目コード</th>
                    <td>${subject.cd}</td>
                </tr>
                <tr>
                    <th>科目名</th>
                    <td>${subject.name}</td>
                </tr>
            </table>
            <form action="SubjectDeleteExecute.action" method="post">
                <input type="hidden" name="cd" value="${subject.cd}">
                <button type="submit" class="btn btn-danger">削除</button>
                <a href="SubjectList.action" class="btn btn-secondary">キャンセル</a>
            </form>
        </section>
    </c:param>
</c:import>