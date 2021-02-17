<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<c:url value='/assets/css/main.css'/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>" />
<title>findWriter.jsp</title>
<script type="text/javascript"
	src="<c:url value='/assets/js/jquery-3.5.1.min.js'/>"></script>
<script type="text/javascript">	
	$(function(){
		$('#submit').click(function(){
			if($('#writer').val().length<1){
				alert('작가명을 입력하세요');
				$('#writer').focus();
				event.preventDefault();
			}
		});
		
	});
	
	function setWrNo(wrNo, writer){
		$(opener.document).find('#wrNo').val(wrNo);
		$(opener.document).find('input[name=writer]').val(writer);
		$(opener.document).find('input[name=chkWrNo]').val("Y");
		self.close();
	}
	
	function goWriterInsert(){
		self.close();
		opener.location.href="<c:url value='/writer/writerInsert.do'/>";
	}
</script>
</head>
<body style="margin:20px;padding:10px;width:450px" >
	<h2>작가번호 검색</h2>
	<br>
	<p><img alt="돋보기 이미지" style="width: 30px"
		src="<c:url value='/images/magnifier.png'/>"> 등록할 작가이름을 조회하세요</p>
	<form name="frmWrNo" method="post" action="findWriter.do">
		<label for="writer"><b>작가이름</b></label>
		<input type="text" name="writer" id="writer" style="width: 200px">
			<input type="submit" id="submit" value="찾기" style="margin-top: 10px;">
			<div style="margin-top: 40px;">
				<p style="color: #c63815">※ 찾으시는 작가가 없을 시엔
					<a href="#" onclick="goWriterInsert()" style="color: #c63815; text-decoration: underline;"><b>신규등록</b></a>을 해야합니다
				</p>
			</div>
	</form>
	<br>
	<table style="width: 470px">
		<colgroup>
			<col style="width: 20%" />
			<col style="width: *" />
		</colgroup>
		<thead>
			<tr style="border-bottom: 2px solid #c18282; text-align: center;">
				<th scope="col">작가번호</th>
				<th scope="col">작가명</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${wList==null}">
				<tr>
					<td colspan="2" style="text-align: center">검색어에 해당하는 작가가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${wList!=null}">
				<c:set var="num" value="${pageVo.num}"/>
				<c:set var="curPos" value="${pageVo.curPos}"/>
				
				<c:forEach var="i" begin="1" end="${pageVo.pageSize}">
					<c:if test="${num>=1}">
						<c:set var="wVo" value="${wList[curPos]}"/>
						<c:set var="curPos" value="${curPos+1}"/>
				 		<c:set var="num" value="${num-1}"/>
						<tr style="text-align: center; border-bottom: solid 1px silver;">
							<td>${wVo.no}</td>
							<td><a href="#"
			onclick="setWrNo('${wVo.no}', '${wVo.name}')">
								${wVo.name}</a>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<div class="paging" style="text-align: center;">
		<c:if test="${pageVo.firstPage>1}">
			<a href="<c:url value='/book/findWriter.do?curPage=${pageVo.firstPage-1}&writer=${param.writer}'/>">
				<img src="<c:url value='/images/first.JPG'/>" alt="이전블럭으로 이동"> 
			</a>
		</c:if>
		
		<c:forEach var="i" begin="${pageVo.firstPage}" end="${pageVo.lastPage}">
			<c:if test="${i<=pageVo.totalPage}">
				<c:if test="${param.curPage==i}">
					<span style="color: #c18282; font-weight: bold">${i}</span>
				</c:if>
				<c:if test="${param.curPage!=i}">
					<a href="<c:url value='/book/findWriter.do?curPage=${i}&writer=${param.writer}'/>">
						[${i}]</a>
				</c:if>
			</c:if>
		</c:forEach>
		
		<c:if test="${pageVo.lastPage<pageVo.totalPage}">
			<a href="<c:url value='/book/findWriter.do?curPage=${pageVo.lastPage+1}&writer=${param.writer}'/>">
				<img src="<c:url value='/images/last.JPG'/>" alt="다음 블럭으로 이동"> 
			</a>
		</c:if>
	</div>
</body>
</html>