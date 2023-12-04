SP.SCOUserJS.txt

----------

Preference name: SCOUserJS

Type: free

Options: 

----------

Preference value: 



$(document).ready(function(){
    $("body").attr('id', 'scopage');
    $(".navbar").hide();
    $(".navbar-static-top").hide();
    $(".header-menu").hide();
    $(".opaccredits").hide();

    $('#patronlogin').keypress(function(e){
        if (e.keyCode == 13){
            $('#patronpw').focus();
            return false;
        }
    });
  
$('#scopage #opac-auth label[for="userid"]').html('Staff login');
$('#scopage #opac-auth #nologininstructions, #scopage #opac-auth #forgotpassword').hide();

});


























