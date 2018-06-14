<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE HTML>
<html>
<head>
    <title> SpringBoot & AWS S3</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script
        src="https://code.jquery.com/jquery-3.3.1.js"
        integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>


<body>
<h1>
    S3 이미지 업로더
</h1>
<div class="col-md-12">
    <div class="col-md-2">
        <form name="form" action="upload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <p>파일 업로드</p>
				<input type="file" class="btn btn-lg " value="파일첨부" style="margin-top:-15px;" name="file"/>
            </div>
            <button type="submit" class="btn btn-primary" id="btn-save">저장</button>
        </form>
    </div>
</div>
</body>
</html>