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
