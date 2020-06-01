<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" 
    integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
  
  <script src="htttps://ajax.googleapis.com/ajsx/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>
     <form class="form-inline">
         <div class="form-group">
	         <label>Name</label>
	         <input type="text" name="name" id="name"/>
         </div>
         <button type ="button" onclick ="search();" class="btn btn-default">Search</button>
     </form>
     <h2>List</h2>
     <table id="result">
        <thread>
            <tr>
                <td>ID</td>
                <td>NAME</td>
            </tr>
        </thread>
     
     </table>
     
     <script type="text/javascript">
       function search(){
    	   $.ajsx({
    		   type:"post",
    		   url:"${pageContext.request.contextPath}/search/",
    		   data:"name=" + $("#name").val(),
    		   success: function(res) {
    			   var result ="<thead><tr><td>ID</td><td>NAME</td></td></tr></thead>";
    			   result += "<tbody>";
    			   $.each(res.function(k,v){
    				   result += "<tr>";
    				   result += "<td>";
    				   result += v.id
    				   result += "</td>";
    				   result += "<td>";
    				   result += v.name
    				   result += "</td>";
    				   result += "</tr>";
    			   });
    			   result += "</tbody>";+
    			   $("#result").html(result);
    		   },
    		   error:function(){
    			   alert('Eoor while request！');
    		   }
    	   });
       }
     </script>
     
     
</body>
</html>