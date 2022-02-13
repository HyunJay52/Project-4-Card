// 테이블의 Row 클릭시 값 가져오기
		$("#member-mng_tbl tr").click(function(){

			var str = ""
			var tdArr = new Array();	// 배열 선언

			// 현재 클릭된 Row(<tr>)
			var tr = $(this);
			var td = tr.children();

			// tr.text()는 클릭된 Row 즉 tr에 있는 모든 값을 가져온다.
			console.log("클릭한 Row의 모든 데이터 : "+tr.text());

			// 반복문을 이용해서 배열에 값을 담아 사용할 수 도 있다.
			td.each(function(i){
				tdArr.push(td.eq(i).text());
			});

			console.log("배열에 담긴 값 : "+tdArr);

			// td.eq(index)를 통해 값을 가져올 수도 있다.
			var no = td.eq(0).text();
			var email = td.eq(1).text();
			var password = td.eq(2).text();
			var joindate = td.eq(3).text();


			str +=	" * 클릭된 Row의 td값 = No. : <font color='red'>" + no + "</font>" +
					", 아이디 : <font color='red'>" + email "</font>" +
					", 이름 : <font color='red'>" + password + "</font>" +
					", 이메일 : <font color='red'>" + joindate + "</font>";

			$("#member-info1").html(" * 클릭한 Row의 모든 데이터 = " + tr.text());
			$("#member-info2").html(str);
		});