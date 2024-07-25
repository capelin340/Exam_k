<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">得点管理システム</c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目管理</h2>
            <div class="my-2 text-end px-4">
                <a href="SubjectCreate.action">新規登録</a>
            </div>
            <c:if test="${not empty message}">
                <div class="alert alert-info" role="alert">
                    ${message}
                </div>
            </c:if>
            <c:choose>
                <c:when test="${not empty subjects}">
                    <div>検索結果：${subjects.size()}件</div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>科目コード</th>
                                <th>科目名</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="subject" items="${subjects}">
                                <tr>
                                    <td>${subject.cd}</td>
                                    <td>${subject.name}</td>
                                    <td>
                                        <a href="SubjectUpdate.action?cd=${subject.cd}">変更</a>
                                        &nbsp;&nbsp;&nbsp;
                                        <a href="SubjectDelete.action?cd=${subject.cd}" onclick="return confirm('本当に削除しますか？');">削除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <div>科目情報が存在しませんでした</div>
                </c:otherwise>
            </c:choose>
        </section>
    </c:param>
</c:import>