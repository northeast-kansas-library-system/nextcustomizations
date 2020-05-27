/* Requires corresponding CSS */
/* Puts the Next Search Catalog on all pages in the staff client - depends on location of the Next Search Catalog logo on the NEKLS website.  Must be the first piece of jQuery in order for the re-logo the test server code to work. */

 //BEGIN re-logo the staff client
  //All pages-url for logo https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png
   $("#header_search").before('<div id="newlogo" style="float: left; padding: 10px; height: 88;"><a href="/cgi-bin/koha/mainpage.pl"><img src="https://nekls.org/wp-content/uploads/2018/03/nekls_next_logo.png" height="50" width="150"><p style="font-size: 75%;">A service of NEKLS</p></a></div>');
