<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">科目更新完了</c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目更新完了</h2>
            <div class="alert alert-info" role="alert">
                ${message}
            </div>
            <a href="SubjectList.action" class="btn btn-primary">科目一覧に戻る</a>
        </section>
    </c:param>
</c:import>