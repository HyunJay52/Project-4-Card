var board_main = {
  init: function() {
    var _this = this;

		//네비바 선택
    $('.group_navi>li').on('click', function() {
      var group_name = $(this).text();
      _this.group_name(group_name)
      alert(group_name);
    });

    //카테고리 선택
    $('.cate_phoca').on('click', function() {
    	$('.cate_phoca').css({
      	'font-size': '18px',
        'color' : 'black',
        'font-weight': 'bold'
      });
      $('.cate_goods').css({
      	'font-size': '16px',
        'color' : '#606060'
      });

      //function 불러오기
      _this.cate_phoca_listing();
    });
		$('.cate_goods').on('click', function() {
    	$('.cate_goods').css({
      	'font-size': '18px',
        'color' : 'black',
        'font-weight': 'bold'
      });
    	$('.cate_phoca').css({
      	'font-size': '16px',
        'color' : '#606060'
      });

       //function 불러오기
       _this.cate_phoca_listing();
    });

    //리스트 선택
    $('.board_list>li').on('click', function() {
      _this.product_list();
    });

    //글쓰기 버튼
    $('#prod_write').on('click', function() {
    alert("글쓰기 누름 ^^");
    });

    // pagination
    $('.pagination_div').twbsPagination({
    		totalPages: 35,	// 총 페이지 번호 수
		    visiblePages: 7,	// 하단에서 한번에 보여지는 페이지 번호 수
		    startPage : 1, // 시작시 표시되는 현재 페이지
		    initiateStartPageClick: false,	// 플러그인이 시작시 페이지 버튼 클릭 여부 (default : true)
		    first : "<<",	// 페이지네이션 버튼중 처음으로 돌아가는 버튼에 쓰여 있는 텍스트
		    prev : "<",	// 이전 페이지 버튼에 쓰여있는 텍스트
		    next : ">",	// 다음 페이지 버튼에 쓰여있는 텍스트
		    last : ">>",	// 페이지네이션 버튼중 마지막으로 가는 버튼에 쓰여있는 텍스트
		    nextClass : "page-item next",	// 이전 페이지 CSS class
		    prevClass : "page-item prev",	// 다음 페이지 CSS class
		    lastClass : "page-item last",	// 마지막 페이지 CSS calss
		    firstClass : "page-item first",	// 첫 페이지 CSS class
		    pageClass : "page-item",	// 페이지 버튼의 CSS class
		    activeClass : "active",	// 클릭된 페이지 버튼의 CSS class
		    disabledClass : "disabled",	// 클릭 안된 페이지 버튼의 CSS class
		    anchorClass : "page-link",	//버튼 안의 앵커에 대한 CSS class

		    onPageClick: function (event, page) {
		    	//클릭 이벤트
				console.log("클릭");
		    }
    })

  },

  //네비바 function > 그룹별, 멤버별 reload function
  group_name: function(group_name) {
    $('#what_name').append(group_name);
    $('.sub_navi').css('display', 'block');
  },


  //cate function > 카테고리별 reload function
  cate_phoca_listing: function() {
  	alert("phoca 선택");
  },
	cate_goods_listing: function() {
  	alert("goods 선택");
  },


	//list function > 상세보기 페이지로 넘겨주기
  product_list: function() {
    alert("clicked product");
    window.location.href = "/market/market_list/content_detail";
  }
}

board_main.init();
