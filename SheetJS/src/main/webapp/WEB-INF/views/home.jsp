
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>js excel example 03</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.14.3/xlsx.full.min.js"></script>
<script>

function excelExport(event){
	excelExportCommon(event, handleExcelDataAll);
}

function excelExportCommon(event, callback){
    var input = event.target;
    var reader = new FileReader();
    reader.onload = function(){
        var fileData = reader.result;
        var wb = XLSX.read(fileData, {type : 'binary'});
        var sheetNameList = wb.SheetNames; // 시트 이름 목록 가져오기 
        var firstSheetName = sheetNameList[0]; // 첫번째 시트명
        var firstSheet = wb.Sheets[firstSheetName]; // 첫번째 시트 
        callback(firstSheet);      
    };
    reader.readAsBinaryString(input.files[0]);
}

function handleExcelDataAll(sheet){

	handleExcelDataJson(sheet); // json 형태
	handleExcelDataHtml(sheet); // html 형태
}

function handleExcelDataJson(sheet){
	var sheetJson = XLSX.utils.sheet_to_json (sheet);
	$("#displayExcelJson").html(sheetJson);
	str='';
	$("#displayExcelJson").append(str);
	for(var i =0; i<sheetJson.length; i++){
		str1='';
		str1+=sheetJson[i].회사이름;
		str1+='&nbsp;'
		str1+=sheetJson[i].주문품번;
		str1+='&nbsp;'
		str1+=sheetJson[i].품명;
		str1+='&nbsp;'
		str1+=sheetJson[i].수량;
		str1+='<br />'
		$("#displayExcelJson").append(str1);
	} 

}

function handleExcelDataHtml(sheet){
    $("#displayExcelHtml").html(XLSX.utils.sheet_to_html (sheet));
}

</script>
</head>
<body>
파일 선택 : <input type="file" id="excelFile" onchange="excelExport(event)"/>

<h1>JSON 형태로 보기</h1>
<div id="displayExcelJson"></div>

<h1>HTML 형태로 보기</h1>
<div id="displayExcelHtml"></div>
</body>
</html>
