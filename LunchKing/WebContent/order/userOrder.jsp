<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
		.container {
			width:600px;
			margin:0 auto;
		}
		ul { /* 순서없는 목록에 적용할 스타일 */
			list-style-type: none; /* 불릿 없앰 */
		}

		label.title { /* class=title인 label에 적용할 스타일 */
			font-weight: bold; /* 굵은 글자 */
			width: 80px; /* 너비 80px */
			float: left; /* 왼쪽부터 배치 */
		}

		div.centered { /* class=centered인 div에 적용할 스타일 */
			text-align: center; /* 가운데 정렬 */
		}

		fieldset { /* 필드셋에 적용할 스타일*/
			margin: 15px 10px; /* 상하 마진 15xp, 좌우 마진 10px */
		}

			fieldset legend { /* 필드셋의 제목 */
				font-weight: bold; /* 굵은 글자 */
				font-size: 18px; /* 글자 크기 18px */
				color: purple; /* 글자색 자주 */
			}

		ul li { /* 목록의 각 항목 */
			margin-bottom: 10px; /* 아래 마진 10px */
		}
</style>
<script src="../scripts/jquery-3.1.1.min.js"></script>
<script>
$(function() {
	// 총 금액 계산
	$("#total").text(${category.price});
	var orderCount = $("#orderCount")
	orderCount.change(function() {
		var totalCharge = orderCount.val() * ${category.price};
		$("#total").text(totalCharge);
	});
	// 총 금액 계산 종료
	
	// 배송 종료 일자 계산
	
	
});
</script>
</head>
<body>
<form action="">
	<div class="container">
		<h1>주문하기</h1>
		<fieldset>
			<legend>개인 정보</legend>
			<ul>
				<li>
					<label for="uname" class="title">상품분류</label>
					<input type="text" id="uname" value="${category.categoryId}">
				</li>
				<li>
					<label for="tel1" class="title">이미지</label>
					<input type="text" id="uname" value="${category.categoryImage}">
				</li>
			</ul>
		</fieldset>
		<fieldset>
			<legend>주문 정보</legend>
			<ul>
				<li>
					<label for="addr" class="title">주문 기간</label>
					<input type="radio" name="orderTerm" value="7">1주
					<input type="radio" name="orderTerm" value="14">2주
					<input type="radio" name="orderTerm" value="21">3주
					<input type="radio" name="orderTerm" value="28">4주
				</li>
				<li>
					<label for="tel2" class="title">첫 배송일</label>
					<input type="date" name="shipStartDate">
				</li>
				<li>
					<label for="tel2" class="title">배송 기간</label>
					<span id="startDate"></span>~<span id="shipEndDate"></span>
				</li>
				<li>
					<label for="comment" class="title">갯수</label>
					<input type="number" id="orderCount" name="orderCount" value="1" min="1">
				</li>
				<li>
					<label for="comment" class="title">총 금액</label>
					<span id="total"></span>
				</li>
			</ul>
		</fieldset>
		<div class="centered">
			<input type="submit" value="장바구니">
			<input type="reset" value="다시 작성">
		</div>
	</div>
</form>
</body>
</html>