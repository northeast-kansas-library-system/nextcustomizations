/* This puts a blue background on all pages on our test server staff client and adds warning text to the top of all pages */

//TEST SERVER
 //BEGIN blue background on test
  var url = $(location).attr('href');
  if(url.indexOf("staff-test") != -1){
   $("body").css("background-image", "url(https://nekls.org/wp-content/uploads/2018/09/test.server100.jpg)");
   $(".gradient").prepend("<div><h1 align='center'>! TEST SERVER !</h1></div>");
  }
