<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>





<div class="container">
	<form action="/blog/test" method="POST">
		
		<div class="form-group">
			<label for="title">Title:</label>
			<input type="text" class="form-control" placeholder="title" id="title" name="title">
		</div>
	
		<div class="form-group">
			<label for="content">Content:</label>
			<textarea id="summernote" class="from-control" rows="5" id="content" name="content"></textarea>
		</div>
	
		<button type="submit" class="btn btn-primary">글쓰기 등록</button>
	</form>
</div>

<script>
  $('#summernote').summernote({
      placeholder: '글을 쓰세요',
      tabsize: 2,
      height: 300
    });
  </script>
</body>
</html>


