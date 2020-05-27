/* Causes the left side navbar Search and More (and any other dropdowns you add on the left half of the page) to open when you hover over them */

 //BEGIN open drop-downs on hover
  $(".navbar-nav li.dropdown:lt(3)").hover(function(){
   $(this).addClass("open");
   }, function(){
    $(this).removeClass("open");
   }
  );
