var board_main = {
  init: function() {
    var _this = this;

    $('.group_navi>li').on('click', function() {
      var group_name = $(this).text();
      _this.group_name(group_name)
      alert(group_name);
    });

    $('.board_list>li').on('click', function() {
      _this.product_list();
    });

  },

  group_name: function(group_name) {
    $('#what_name').append(group_name);
    $('.sub_navi').css('display', 'block');
  },

  product_list: function() {
  	alert("clicked product");
    window.location.href = "/market/market_list/content_detail";
  }
}

board_main.init();
