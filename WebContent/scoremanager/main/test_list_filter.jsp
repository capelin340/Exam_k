<%-- 科目成績一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 科目検索処理 -->
	<form action="TestListSubject.action" method="get">
		<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
			科目情報
			<div class="col-2">
				<label class="form-label" for="student-f1-select">入学年度 </label>
				<select class="form-select " id="student-f1-select" name="f1">
					<option value="0">--------</option>
					<c:forEach var="year" items="${ent_year_set}">
						<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
						<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-2">
				<label class="form-label" for="student-f2-select">クラス</label>
				<select class="form-select " id="student-f2-select" name="f2">
					<option value="0">--------</option>
					<c:forEach var="num" items="${class_num_set}">
						<%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>
						<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-4">
				<label class="form-label" for="student-f2-select">科目</label>
				<select class="form-select " id="student-f2-select" name="f3">
					<option value="0">--------</option>
					<c:forEach var="subject" items="${subjects}">
						<%-- 現在のsubject.cdと選択されていたf3が一致していた場合selectedを追記 --%>
						<option value="${subject.cd}" <c:if test="${subject.cd==f3}">selected</c:if>>${subject.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-2 text-center">
				<button class="btn btn-secondary" id="filter-button">検索</button>
			</div>
			<input type="hidden" name="f" value="sj" /><!-- 識別コード -->
			<div class="mt-2 text-warning">${errors.get("filter_subject")}</div>
		</div>
	</form>
<!-- 学生検索画面 -->
<form action="TestListStudent.action" method="get">
		<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
			学生情報
			<div class="col-4">
				<label class="form-label" for="student-name-input">学生番号</label>
				<input class="form-control" type="text" id="student-name-input"
					name="f4" placeholder="学生番号を入力してください" maxlength="10"
					value="${f4}" required />
			</div>
			<div class="col-2 text-center">
				<button class="btn btn-secondary" id="filter-button">検索</button>
			</div>
			<input type="hidden" name="f" value="st" /><!-- 識別コード -->
		</div>
	</form>
