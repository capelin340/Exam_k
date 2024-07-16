<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">科目登録</c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目登録</h2>
            <form action="SubjectCreateExecute.action" method="post">
                <div class="mb-3">
                    <label for="cd" class="form-label">科目コード（3桁）</label>
                    <input type="text" class="form-control ${not empty error ? 'is-invalid' : ''}" id="cd" name="cd" value="${subject.cd}" required pattern="\d{3}" title="3桁の数字を入力してください">
                    <c:if test="${not empty error}">
                        <div class="invalid-feedback">
                            ${error}
                        </div>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">科目名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${subject.name}" required>
                </div>
                <button type="submit" class="btn btn-primary">登録</button>
                <a href="SubjectList.action" class="btn btn-secondary">戻る</a>
            </form>
        </section>
    </c:param>
</c:import>