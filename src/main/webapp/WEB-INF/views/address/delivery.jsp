
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<c:import url="../template/bootstrap.jsp"></c:import>
<link href ="../resources/css/common/default.css" rel="stylesheet">
<link href ="../resources/css/address/address.css" rel="stylesheet">
<script src="../resources/js/header.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<div class="content">
		<div class="sub-type store">
			<div class="inner-box">
				<div class="page-title-wrap">
					<h2 class="page-title">주문방법 선택</h2>
					<!-- <div class=""> 홈 > 매장검색
					
					</div> -->
					
				</div>
				<div class="sel-order-area">
					<div class="sel-order-wrap">
						<div class="sel-order-way" id="select"> 
							<div class="order-btn order1">
								<a href="./delivery" class="active">배달 주문</a>
							</div>
							<div class="mid-bar"></div>
							<div class="order-btn order2">
								<a href="./pickup">포장 주문</a>
							</div>
						</div>
					</div>
					<div class="tab-content" id="delivery">
						<div class="spot-area">
							<span class="spot left-spot">
								<img alt="" src="../resources/images/address/sp_deli_spot_t1.png" style="width: 23px; height: 24px;">밖에서 도미노피자 먹고 싶을 땐?
							</span>
							
							<a href="#" class="spot right-spot">
								<span>DOMINO SPOT 배달</span><i class="material-icons">chevron_right</i>
							</a>
						</div>
						<div class="addr-list">
							<ul>
								<li>
									<div class="notyet">
										<p class="title"><img alt="" src="../resources/images/address/sp_alert_t1.png"> 배달 주소를 등록해주세요.</p>
										<a href="#" class="btn-type-brd2" id="add_addr">
											+ 배달 주소 등록
										</a>
									</div>
								</li>
							</ul>
							<div class="addr-limit">
								* 배달 주소는 최대 10개까지만 등록 가능합니다.
							</div>
						</div>
					</div>
				</div>	<!-- 배달/포장 -->
			</div>	<!-- 주문방법선택 -->	
		</div>			
	</div><!-- content -->
</div><!-- container -->

<script>
// Add active class to the current button (highlight it)
	var header = document.getElementById("select");
	var btns = header.getElementsByClassName("order-btn");
	for (var i = 0; i < btns.length; i++) {
	  btns[i].addEventListener("click", function() {
	  var current = document.getElementsByClassName("active");
	  current[0].className = current[0].className.replace(" active", "");
	  this.className += " active";
	  });
	}
</script>

<!-- ===== footer ===== -->
<c:import url="../template/footer.jsp"></c:import>

</body>
</html>