$(document).ready(function() {
//never delete anything above this comment

//BEGIN re-logo the staff client (goes first)
 //All pages-url for logo https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png
  $("#header_search").before('<div id="newlogo" style="float: left; padding: 10px; height: 88;"><a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png" height="50" width="150"><p style="font-size: 75%;">A service of NEKLS</p></a></div>');

 //BEGIN add logged in branchcode as class to all pages
  var loglibbc = $(".logged-in-branch-code").first().text().trim()
  $("body").addClass(loglibbc);
 //BEGIN add shortbranch codes
  var sloglibbc = $(".logged-in-branch-code").first().text().trim().substring(0,4);
 //Begin store logged in branchname as var
  var loglibname = $(".logged-in-branch-name:first").text().trim();
 //Begin store logged in branchname as var
  var shortloglibname = $(".logged-in-branch-name:first").text().trim().substring(0,5);

//Special code for the test server
 //BEGIN blue background on test
  var url = $(location).attr('href');
  if(url.indexOf("staff-test") != -1){
   $("body").css("background-image", "url(https://nekls.org/wp-content/uploads/2018/09/test.server100.jpg)");
   $(".gradient").prepend("<div><h1 align='center'>! TEST SERVER !</h1></div>");
   $(".gradient").prepend("<div><h1 align='center'>! George is updating many features in preperation for the June 27, 2020 upgrade !</h1></div>");
    $("#newlogo").html('<a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2020/06/test.png" height="60" width="180"><p style="font-size: 75%;">A service of NEKLS</p></a>');
  }

 //BEGIN add individual library logos to staff client
  var logliblogo = $(".logged-in-branch-code:first").text().trim().toLowerCase();
  $('#header_search').parent().append('<div id="liblogo" style="float: right; padding: 10px; max-height: 88px; background: #a6d7f2 !important;"><img alt="' + loglibname + '"src="https://nekls.org/wp-content/uploads/2020/05/' + logliblogo + '.png" style="max-height: 50px; float: right;"><br /><p style="font-size: 75%; float: right;">'+ loglibname +'</p></div>');

//Special code applied to all pages
 //BEGIN Creates to html function
  $.fn.toHtml=function(){
   return $(this).html($(this).text())
  }

 //BEGIN addresses lastborrower security concern
  $.cookie("lastborrowercard", null, { path: '/' });
  $.cookie("lastborrowername", null, { path: '/' });
  $.cookie("lastborrowernumber", null, { path: '/' });

 //BEGIN adds date in mm/dd/yyyy format to #todaysdate on every page in the system - very useful
  var now = new Date();
  var day = ('0' + now.getDate()).slice(-2);
  var month = ('0' + (now.getMonth() + 1)).slice(-2);
  var year = ('0' + (now.getFullYear())).slice(-4);
  var now = (month) + '/' + (day) + '/' + (year);
  $('.gradient').before('<span id="todaysdate" style="display: none;">' + now + '</span>');

 //BEGIN Prevent Checkout search for short strings
  $("#patronsearch").on('submit', function(e){
   e.preventDefault();
   var len = $('#findborrower').val().length;
   if (len > 3 && len > 1) {
    this.submit();
    } else {
    alert("Please enter four or more characters to perform a checkout search to avoid returning too many results");
   }
  });

  //Add label for "Shelving location:" and put it on new line after home library
   $('#catalog_detail .shelvingloc').prepend('<br /><br />Shelving location:<br />');

  //Enhance "CART" shelving location
   $('#catalog_detail .shelvingloc:contains("Recently returned")').prepend('<i class="fa fa-exclamation-circle" style="color: #b30000;"></i>&nbsp;').parent().css('background','#ffb3ff');

 //BEGIN lock club creation to logged in branch + other branches in district
  if (window.location.href.indexOf("clubs-add-modify.pl") > -1) {
   $('#clubs_add_modify option[value='+ loglibbc +']').attr('selected','selected');
   $('#clubs_add_modify option[value!='+ loglibbc +']').hide();
   $('#clubs_add_modify option[value^='+ sloglibbc +']').show();
  }

//never delete anything below this comment
});
