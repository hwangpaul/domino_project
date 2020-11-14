<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <c:import url="../template/bootstrap.jsp"></c:import>
  <link href ="../resources/css/common/default.css" rel="stylesheet">
  <script src="../resources/js/header.js"></script>
  <!-- include summernote css/js -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="container">
 		<h2>dominoNews Write Form</h2>
  		<form id="frm" action="./dominoNewsWrite" method="post" enctype="multipart/form-data">
  
		    <div class="form-group">
		      <label for="title">Title:</label>
		      <input type="text" class="form-control" id="title" placeholder="Enter Title" name="board_title">
		    </div>
	    
		    <div class="form-group">
		      <label for="writer">Writer:</label>
		      <input type="text" class="form-control"  value="" id="writer" placeholder="Enter Writer" name="board_writer">
		    </div> 
		    
		     <div class="form-group">
		      <label for="contents">Contents:</label>
		      <textarea class="form-control" rows="20" cols="30" id="contents" name="board_contents"></textarea>
		    </div>
		    
		     
	<input type="button" value="FileAdd" id="fileAdd" class="btn btn-info">

	<div id="files">

	</div>  
	
	 <div id="f">
  	  <div class="input-group">
        <input id="files" type="file" class="form-control" name="files">
        <span class="input-group-addon del">DEL</span>
      </div>
  </div>
  
 

		    
		    
	    
	 		<div class="form-group">
	 		<label></label>
	   	    <input type="button" class="btn btn-primary form-control" value="Write" id="btn">
	        <button type="submit" class="btn btn-default form-control">Write</button>
	    	</div>
  		</form>
  
	</div>
	
	<c:import url="../template/footer.jsp"></c:import>

	<script type="text/javascript">
	var count=0;
	
	
	 $('#contents').summernote({
		 height:300,
		 callbacks:{
			 onImageUpload:function(files, editor, welEditable){
				 var formData = new FormData();	    //가상의 from 태그 작성
				 formData.append('file', files[0]); //파라미터 이름 file
				 
				 $.ajax({
				    data: formData,
				    type: "POST",
				    url: 'summernote',
				    cache: false,
				    contentType: false,
				    enctype: 'multipart/form-data',
				    processData: false,
					 success:function(data){
						 data = data.trim();
						 $("#contents").summernote('editor.insertImage', data);
					 }
				 })
			 },//upload End
			 
			 onMediaDelete:function(files){
				 var fileName = $(files[0]).attr("src");
				 //fileName에서 파일명만 구해오기
				 //s4/resources/upload/qna/sdfa-sdfsdf_iu1.jpg
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				
				$.ajax({
					type:"POST",
					url : "./summernoteDelete",
					data: {
						file:fileName
					},
					success:function(data){
						alert(data);
					}
				
				}); 
			 }
		 }
		
	 });
	 
	 $('#btn').click(function() {
		var contents = $('#board_contents').summernote('code');
		alert(contents);
		
	});
	 
		$("#files").on("click", ".del", function() {
			$(this).parent().remove();
			count--;
		});
		
		$("#fileAdd").click(function() {
			
			if(count<5){
				var f = $("#f").html().trim();
				
				$("#files").append(f);
				count++;
			}else {
				alert("첨부파일은 최대 5개")			
			}
		});

</script>


</body>
</html>