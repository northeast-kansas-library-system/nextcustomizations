/* This creates a function that renders text in HTML in places where HTML is not allowed */

//Special functions
 //BEGIN Creates to html function
  $.fn.toHtml=function(){
   return $(this).html($(this).text())
  }
