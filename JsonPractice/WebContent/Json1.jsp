<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(function() {			
			$("#checkJson").click(function() {		
				let jsonStr = '{ "name": "Alpha", "age":20, "gender": "남자", "nickname":"알파" }';
				
				let jsonObject = JSON.parse(jsonStr);		// 문자열을 JSON 객체로 변환
				
				let output = "회원 정보<br>";
				output += "=========<br>";
				output += "이름 : " + jsonObject.name + "<br>";
				output += "나이 : " + jsonObject.age + "<br>";
				output += "성별 : " + jsonObject.gender + "<br>";
				output += "별명 : " + jsonObject.nickname + "<br>";
				
				$("#output").html(output);
			});
			
			$("#checkJson2").on("click", function() {		
				let jsonStr = '{ "age": [22, 33, 44] }';
				
				let jsonInfo = JSON.parse(jsonStr);		// 문자열을 JSON 객체로 변환
				
				let output = "회원 나이<br>";
				output += "=========<br>";
				
				for (let i in jsonInfo.age) {
					output += jsonInfo.age[i] + "<br>";
				}

				$("#output2").html(output);
			});
			
			$("#checkJson3").click(function() {
				let jsonStr = '{ "name": ["Alpha", "Bravo", "Charlie"] }';
				
				let stringToJson = JSON.parse(jsonStr);		// 문자열을 JSON 객체로 변환
				
				let jsonToString = JSON.stringify(stringToJson);		// JSON 객체를 문자열로 변환
				
				$("#output3").html(jsonToString);
			});
			
			$("#checkJson4").click(function() {
				let jsonStr = '{ "members": [{ ' +
						'"name": "Alpha", "age": 20, "gender": "남자", "nickname": "알파"' +
					'}, {' +
						'"name": "Bravo", "age": 19, "gender": "여자", "nickname": "브라보"' +
					'}]' +
				'}';
				
				let jsonObject = JSON.parse(jsonStr);
				let memberList = jsonObject.members;

				let output = "멤버 정보<br>";
				for(let index in memberList) {
					output += "=========<br>";
					output += "이름 : " + memberList[index].name + "<br>";
					output += "나이 : " + memberList[index].age + "<br>";
					output += "성별 : " + memberList[index].gender + "<br>";
					output += "별명 : " + memberList[index].nickname + "<br>";
				}

				$("#output4").html(output);
			});
		});
	</script>
</head>

<body>
	<a id="checkJson" style="cursor: pointer;"><h3>문자열을 JSON으로 변환 후 Key를 활용해 Value 출력</h3></a> <br>
	<div id="output"></div>
	
	<hr>
	
	<a id="checkJson2" style="cursor: pointer;"><h3>만들어진 JSON 데이터를 반복문으로 출력</h3></a> <br>
	<div id="output2"></div>
	
	<hr>
	
	<a id="checkJson3" style="cursor: pointer;"><h3>JSON 객체를 문자열로 변환</h3></a> <br>
	<div id="output3"></div>
	
	<hr>
	
	<a id="checkJson4" style="cursor: pointer;"><h3>출력</h3></a> <br>
	<div id="output4"></div>
</body>

</html>