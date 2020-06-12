$(document).ready(function() {
//never delete anything above this comment

//BEGIN re-logo the staff client (goes first)
 //All pages-url for logo https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png
  $("#header_search").before('<div id="newlogo" style="float: left; padding: 10px; height: 88;"><a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png" height="50" width="150"><p style="font-size: 75%;">A service of NEKLS</p></a></div>');

//Special code for the test server
 //BEGIN blue background on test
  var url = $(location).attr('href');
  if(url.indexOf("test") != -1){
   $("body").css("background-image", "url(https://nekls.org/wp-content/uploads/2018/09/test.server100.jpg)");
   $(".gradient").prepend("<div><h1 align='center'>! TEST SERVER !</h1></div>");
   $(".gradient").prepend("<div><h1 align='center'>! George is updating many features in preperation for the June 27, 2020 upgrade !</h1></div>");
    $("#newlogo").html('<span id="testlogo"><a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2020/05/test.png" height="50" width="150"><p style="font-size: 75%;">A service of NEKLS</p></a></span>');
  }

//Special code applied to all pages
 //BEGIN Creates to html function
  $.fn.toHtml=function(){
   return $(this).html($(this).text())
  }

 //BEGIN addresses lastborrower security concern
  $.cookie("lastborrowercard", null, { path: '/' });
  $.cookie("lastborrowername", null, { path: '/' });
  $.cookie("lastborrowernumber", null, { path: '/' });

 //BEGIN add logged in branchcode as class to all pages
  var branchescode = $(".logged-in-branch-code").first().text().trim()
  $("body").addClass(branchescode);

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

//Specific library changes

 //LEAVENWRTH specific
 //Kanopy
  //Adds class to KANOPY allowed attribute
   $('.LEAVENWRTH label:contains("Kanopy (LEAVENWRTH):")').parent().addClass('leavenwrthkanopy');
  //Adds Kanopy allowed value to new patrons created at LEAVENWRTH only on new users
   var url = $(location).attr('href');
    if(url.indexOf("memberentry.pl?op=add") != -1){
     $('.leavenwrthkanopy select option[value=LEAVENWRTH]').attr("selected","selected");
    }
  //Changes to Kanopy not allowed when home library is changed to not-LEAVENWRTH
   $('.LEAVENWRTH #libraries').change(function () {
    $('.leavenwrthkanopy select option[value="0"]').attr("selected","selected");
   });
  //Changes to Kanopy allowed when home library is changed to LEAVENWRTH
   $('.LEAVENWRTH #libraries option[value=LEAVENWRTH]').click(function () {
    $('.leavenwrthkanopy select option[value=LEAVENWRTH]').attr("selected","selected");
   });


//never delete anything below this comment
});
