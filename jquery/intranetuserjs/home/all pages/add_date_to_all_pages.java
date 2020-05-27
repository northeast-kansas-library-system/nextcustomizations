/* Adds date inot a hidden span in front of the gradient.  Allows you to use jQuery to plug today's date into places you might want it. This is like adding the branch name as a class to the body of every page.  It can be useful. */

 //BEGIN adds date in mm/dd/yyyy format to #todaysdate on every page in the system - very useful
  var now = new Date();
  var day = ('0' + now.getDate()).slice(-2);
  var month = ('0' + (now.getMonth() + 1)).slice(-2);
  var year = ('0' + (now.getFullYear())).slice(-4);
  var now = (month) + '/' + (day) + '/' + (year);
  $('.gradient').before('<span id="todaysdate" style="display: none;">' + now + '</span>');
