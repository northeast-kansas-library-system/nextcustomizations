/* This puts a blue background on all pages on our test server staff client and adds warning text to the top of all pages */

//Special code for the test server
 //BEGIN blue background on test
  var url = $(location).attr('href');
  if(url.indexOf("staff-test") != -1){
   $("body").css("background-image", "url(https://nekls.org/wp-content/uploads/2018/09/test.server100.jpg)");
   $(".gradient").prepend("<div><h1 align='center'>! TEST SERVER !</h1></div>");
   $(".gradient").prepend("<div><h1 align='center'>! George is updating many features in preperation for the June 27, 2020 upgrade !</h1></div>");
    $("#newlogo").html('<span id="testlogo"><a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2020/05/test.png" height="50" width="150"><p style="font-size: 75%;">A service of NEKLS</p></a></span>');
  }
