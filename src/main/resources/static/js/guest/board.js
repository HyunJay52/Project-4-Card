var board_main = {
  init: function() {
    var _this = this;

    $('.group_list>li').on('click', function() {
      var group_name = $(this).text();
      _this.group_name(group_name)
      alert(group_name);
    });

  },

  group_name: function(group_name) {
    $('#what_name').append(group_name);
    $('.sub_navi').css('display', 'block');
  }
}

board_main.init();
