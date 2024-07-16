<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
    <c:param name="title">科目更新</c:param>
    <c:param name="content">
        <section class="me-4">
            <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">科目更新</h2>
            <form action="SubjectUpdateExecute.action" method="post">
                <div class="mb-3">
                    <label class="form-label">科目コード</label>
                    <p class="form-control-static">${subject.cd}</p>
                    <input type="hidden" name="cd" value="${subject.cd}">
                </div>
                <div class="mb-3">
                    <label for="name" class="form-label">科目名</label>
                    <input type="text" class="form-control" id="name" name="name" value="${subject.name}" required>
                </div>
                <button type="submit" class="btn btn-primary">更新</button>
                <a href="SubjectList.action" class="btn btn-secondary">戻る</a>
            </form>
        </section>
    </c:param>
</c:import>