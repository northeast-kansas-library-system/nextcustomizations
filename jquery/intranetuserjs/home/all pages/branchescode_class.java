/* Adds the branchcode as a class to all pages in the staff client - allows branch-by-branch customizations */

 //BEGIN add logged in branchcode as class to all pages
  var branchescode = $(".logged-in-branch-code").first().text().trim()
  $("body").addClass(branchescode);
