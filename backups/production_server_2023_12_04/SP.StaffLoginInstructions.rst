SP.StaffLoginInstructions.txt

----------

Preference name: StaffLoginInstructions

Type: Free

Options: 

----------

Preference value: 



<script type="text/javascript">
  //<![CDATA[

function init() {

//Creates an upgrade message on login page
  $("#main_auth.main_main-auth #login").parent().prepend("<h3 id='upgrade_note' class='next_login_message' style='display: none; text-align: center;'></h3><h3 style='text-align: center; display: none;'><a href='https://northeast-kansas-library-system.github.io/nextsteps/upgrades/upgrade_clear_cache.html' target='_blank'>Clear your browser cache (type \"SHIFT-CTRL-DELETE\") after the upgrade</a></h3>");

//Creates contact info on login page
  $("#main_auth.main_main-auth #login").after("<h3 id='login_contact_info' style='text-align: center;'>Next Search Catalog contact info</h3><h4 style='text-align: center;'><li>E-mail support: nexthelp@nekls.org</li><li>NEKLS: 785-838-4090</li><li>Toll free: 888-296-6963</li><li>After hours: 785-813-1356</li></h4>");

//adds hover function to login message on login page
  $('.next_login_message').hover(function() {
    $( ".next_login_message" ).css("background-color","#FFFF00");
      }, function(){
    $( ".next_login_message" ).css("background-color","#E6F0F2");
  });

//Adds Next Search Catalog text logo on login page
  $("#login > form").before('<div id="next_logo" style="font-family: \'Tahoma\', \'Arial\', sans-serif !important; text-align: center; font-size: 1.75em;"><h2 style="color: #1f9bde; font-weight: 1000; padding-top: 5px; line-height: .25em; font-size: 3em;">NE<span style="color: #0157b9">X</span>T</h2><h5 style="color: #838689; text-decoration: underline;font-style: italic;">SEARCH CATALOG</h5><p style="font-size: 75%;"><a href="https://nekls.org/" target="_blank">A service of NEKLS</a></p></div>');

//Adds instruction to the "Locked account" message on login page
  $('#login_error:contains("locked")').addClass('lockedaccount');

  $('#login .lockedaccount').parent().before('<div id="lockedouthelp"><h3><a href="https://youtu.be/1Mep57eVAnY" target="_blank">Click here for a tutorial video on unlocking your account</a></h3><h3><a href="https://northeast-kansas-library-system.github.io/nextsteps/pages/loging_in_docs/staff_password_self_reset.html" target="_blank">Click here for full instructions on resetting your password</a></h3></h3><h3><a href="https://northeast-kansas-library-system.github.io/nextsteps/_downloads/bf4584513fbf283f8af15460bda39997/staff_password_self_reset.pdf" target="_blank">Click here for printable instructions on resetting your password</a></h3></div>');

//Hides library drop-down on login page
  $('#branch').parent().hide();

}

//makes this script run when the login page loads
  window.onload = init;

  //]]>
</script>

<style>
/* Re-styles "You must reset your password" link when visible */  
  #login > a {
    display: block; 
    width: 100%; 
    margin: 0 auto; 
    font-size: 150%; 
    text-decoration: underline;
    text-align: center;
  }

/* Postitions "Locked out help" div when visible */
  #lockedouthelp {
    display:block; 
    width: 100%; 
    margin: 0 auto; 
    font-size: 200%; 
    text-decoration: underline;
    text-align: center;
  }
  
/* Hides Koha logo on staff interface login page */
  #main_auth #login h1 {
    display: none;
  }
</style>

























