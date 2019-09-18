<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>

<h1 id="jsonp"></h1>


<body>
	
</body>


<script src="https://cdnjscn.b0.upaiyun.com/libs/jquery/2.1.1/jquery.min.js"></script>
  <script src="http://cdnjscn.b0.upaiyun.com/libs/json2/20130526/json2.min.js"></script>
  <script src="http://cdnjscn.b0.upaiyun.com/libs/underscore.js/1.6.0/underscore-min.js"></script>
  <script src="http://cdnjscn.b0.upaiyun.com/libs/backbone.js/1.1.2/backbone-min.js"></script>

<script type="text/javascript">


	// function httpGet(url, method, data) {  
 //    var xmlhttp;  
 //    xmlhttp = new XMLHttpRequest();  
 //    xmlhttp.open (method, url , false);  
 //    xmlhttp.setRequestHeader ("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");  
 //    xmlhttp.setRequestHeader ("Content-Length", data.length);  
 //    xmlhttp.send (null);  
 //    if (xmlhttp.Status = 200) return xmlhttp.responseText;  
	// }  
	// var s  = httpGet("http://localhost:8080/getUser", "GET", "do=GET");
	// alert(s);
 //  	document.write (s);  

 var PageController = Backbone.Router.extend({
    routes: {
        'index': 'index' //#help
    },
    index: function () { alert('index'); },
    help: function () { },
    search: function () { }
});

</script>
</html>