
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>SheetJS Live Grid Demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/img/logo.png" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/sheetjs.css">
  </head>
  <body>
    <script src="assets/vendor/alertify.js"></script>
    <script src="//unpkg.com/canvas-datagrid/dist/canvas-datagrid.js"></script>

    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resources/assets/vendor/samples.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resources/assets/vendor/alertify.css">

    <div id="body">
      <div id="left">
      <div id="drop">Drop a file here</div>
      <input type="file" id="file" value=""/><label for="file">... or click here to select a file</label>
      <h3> Choose a worksheet:</h3>
      <div id="buttons"></div>
    </div>
    <div id="right">
      <div id="header">
        <pre id="out"></pre>
       
        
      </div>
      <div id="grid"></div>
      <div id="footnote">
        
       
      </div>
    </div>

    <script src="${pageContext.request.contextPath}/resources/assets/js/shim.js"></script>
    <script src="//unpkg.com/xlsx/dist/xlsx.full.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/dropsheet.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/resources/assets/vendor/spin.js"></script>
    <script type="text/javascript">
      var _gaq = _gaq || [];
      _gaq.push(['_setAccount', 'UA-36810333-1']);
      _gaq.push(['_setDomainName', 'sheetjs.com']);
      _gaq.push(['_setAllowLinker', true]);
      _gaq.push(['_trackPageview']);

      (function() {
      var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
      ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
      var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
      })();
    </script>
  </body>
</html>